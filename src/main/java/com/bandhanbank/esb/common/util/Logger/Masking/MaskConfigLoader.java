package com.bandhanbank.esb.common.util.Logger.Masking;


import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class MaskConfigLoader {

    public List<MaskElementConfig> loadMaskConfigurations(String configFilePath) {
        List<MaskElementConfig> maskElementConfigs = new ArrayList<>();

        try (JsonReader jsonReader = Json.createReader(new FileReader(configFilePath))) {

            JsonObject configJson = jsonReader.readObject();
            JsonObject defaultConfig = configJson.getJsonObject("defaultConfig");
            String defaultStartPattern = defaultConfig.getString("elementStartPattern");
            String defaultEndPattern = defaultConfig.getString("elementEndPattern");
            int defaultNoMaskCount = defaultConfig.getInt("countOfLastCharsNotToMask");

            JsonArray maskElements = configJson.getJsonArray("maskElementsConfig");

            for (JsonObject element : maskElements.getValuesAs(JsonObject.class)) {
                String elementName = element.getString("elementName");
                String startPattern = element.getString("elementStartPattern", defaultStartPattern);
                String endPattern = element.getString("elementEndPattern", defaultEndPattern);
                int noMaskCount = element.getInt("countOfLastCharsNotToMask", defaultNoMaskCount);

                maskElementConfigs.add(new MaskElementConfig(elementName, startPattern, endPattern, noMaskCount));
            }
        } catch (Exception e) {
            throw new RuntimeException("Error loading mask configuration from file: " + configFilePath, e);
        }

        return maskElementConfigs;
    }
}