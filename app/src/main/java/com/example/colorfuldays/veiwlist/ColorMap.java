package com.example.colorfuldays.veiwlist;

import java.util.HashMap;
import java.util.Map;

public class ColorMap
{
    private Map<String, String> ColorMap()
    {
        Map<String, String> colorMap = new HashMap<>();

        colorMap.put("Anger", "#ff6969");
        colorMap.put("Confusion", "#ffc085");
        colorMap.put("Exciting", "#fff785");
        colorMap.put("Normal", "#b9faa0");
        colorMap.put("Joy", "#ffbcb8");
        colorMap.put("Sad", "#9eb1ff");
        colorMap.put("Tired", "#9578ff");
        colorMap.put("Melancholy", "#c587ff");

        return colorMap;
    }
}
