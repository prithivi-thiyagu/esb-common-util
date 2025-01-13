package com.bandhanbank.esb.common.util.Logger.Masking;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Getter
@Setter
public class MaskElementConfig {
    private final String elementName;
    private final Pattern startPattern;
    private final Pattern endPattern;
    private final int lastCharsNoMaskCount;

    public MaskElementConfig(String elementName, String startPattern, String endPattern, int lastCharsNoMaskCount) {
        this.elementName = elementName;
        this.startPattern = Pattern.compile(startPattern.replaceAll("##elementName##", elementName));
        this.endPattern = Pattern.compile(endPattern.replaceAll("##elementName##", elementName));
        this.lastCharsNoMaskCount = lastCharsNoMaskCount;
    }

}