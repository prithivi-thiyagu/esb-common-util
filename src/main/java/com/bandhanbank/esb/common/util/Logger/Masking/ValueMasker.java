package com.bandhanbank.esb.common.util.Logger.Masking;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

@Getter
@Setter
@Service
public class ValueMasker {

    private MaskConfigLoader maskConfigLoader;
    private List<MaskElementConfig> maskConfigurations;
    private String configFilePath;

    @Autowired
    public ValueMasker(MaskConfigLoader maskConfigLoader){
        this.maskConfigLoader = maskConfigLoader;
    }

    private static StringBuilder maskElementValue(MaskElementConfig maskElem, StringBuilder message) {
        Matcher matcher = maskElem.getStartPattern().matcher(message.toString());
        while (matcher.find()) {
            int lastPos = matcher.end();
            Matcher endMatcher = maskElem.getEndPattern().matcher(message.substring(lastPos));
            if (endMatcher.find()) {
                maskValue(message, lastPos, lastPos + endMatcher.start(), maskElem.getLastCharsNoMaskCount());
            }
        }

        return message;
    }

    private static void maskValue(StringBuilder strBldr, int startPos, int endPos, int noMaskCount) {
        if ((endPos - startPos) > noMaskCount) {
            strBldr.replace(startPos, endPos - noMaskCount, new String(new char[endPos - startPos - noMaskCount]).replace('\0', 'X'));
        } else {
            strBldr.replace(startPos, endPos, new String(new char[endPos - startPos]).replace('\0', 'X'));
        }
    }

    public String[] maskParameters(String[] params) {
        List<String> paramList = new ArrayList<String>(params.length);
        List<String> ParaElmtsList = Arrays.asList(params).stream().collect(Collectors.toList());
        System.out.println(paramList.isEmpty());

        if (this.getConfigFilePath() != null)
            maskConfigurations = maskConfigLoader.loadMaskConfigurations(configFilePath);
        else
            throw new RuntimeException("MaskConfig file path is not set or incorrect");

        if (paramList.isEmpty()) {
            ParaElmtsList.stream().forEach(s -> {
                String str1 = s.toString().substring(0, s.toString().indexOf("="));
                Optional<MaskElementConfig> dataobj = maskConfigurations.stream().filter(o -> o.getElementName().equals(str1)).findFirst();

                if (dataobj.isPresent()) {

                    paramList.add(maskElementValue(dataobj.get(), new StringBuilder(s)).toString());
                } else {
                    paramList.add(new StringBuilder(s).toString());
                }
            });
        }
        ParaElmtsList.clear();
        return paramList.toArray(new String[paramList.size()]);
    }

    private static boolean isJson(String inputString) {
        try {
            new JSONObject(inputString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isXml(String inputString) {
        try {
            String str1;
            if (inputString.contains("<")) {
                str1 = inputString;
            } else {
                str1 = "<" + inputString + ">";
            }
            XML.toJSONObject(str1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private ArrayList<String> JsonKeyList(StringBuilder message) throws JsonParseException, IOException {
        List<String> keys = new ArrayList<>();
        JsonFactory factory = new JsonFactory();
        JsonParser jsonParser = factory.createParser(message.toString());
        while (!jsonParser.isClosed()) {
            if (jsonParser.nextToken() == JsonToken.FIELD_NAME) {
                keys.add((jsonParser.getCurrentName()));
            }
        }
        return (ArrayList<String>) keys;
    }

    private ArrayList<String> XMLKeyList(String message) throws ParserConfigurationException, SAXException, IOException {
        List<String> keys = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(message)));
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                keys.add(element.getNodeName());
            }
        }
        return (ArrayList<String>) keys;
    }

    public String maskRequestResponse(String reqRes) {

        StringBuilder message = new StringBuilder(reqRes);
        if (isJson(reqRes)) {
            if (message != null) {
                List<String> PayloadElmtsList;

                if (this.getConfigFilePath() != null)
                    maskConfigurations = maskConfigLoader.loadMaskConfigurations(configFilePath);
                else
                    throw new RuntimeException("MaskConfig file path is not set or incorrect");

                try {
                    PayloadElmtsList = JsonKeyList(message).stream().distinct().collect(Collectors.toList());
                    PayloadElmtsList.stream().forEach(s -> {
                        Optional<MaskElementConfig> dataobj = maskConfigurations.stream().filter(o -> o.getElementName().equals(s.toString())).findFirst();
                        if (dataobj.isPresent()) {
                            maskElementValue(dataobj.get(), message);
                        }
                    });

                    PayloadElmtsList.clear();

                } catch (JsonParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        } else if (isXml(reqRes)) {
            if (message != null) {
                List<String> PayloadElmtsList;
                try {
                    PayloadElmtsList = XMLKeyList(reqRes).stream().distinct().collect(Collectors.toList());
                    PayloadElmtsList.stream().forEach(s -> {
                        Optional<MaskElementConfig> dataobj = maskConfigurations.stream().filter(o -> o.getElementName().equals(s.toString())).findFirst();
                        if (dataobj.isPresent()) {
                            maskElementValue(dataobj.get(), message);
                        }
                    });

                    PayloadElmtsList.clear();
                } catch (ParserConfigurationException | SAXException | IOException e) {
                    // TODO Auto-generated catch block
                    return message.toString();
                }

            }
        }

        return message.toString();

    }

}
