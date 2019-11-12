package com.xiazeyu.plugin.bookmark.util;

import java.util.*;

public class LabelUtil {

    public static Map<String, List<String>> analysisLabel(String label, int beginIndex, List<String> contextList) {
        Map<String, List<String>> result = new HashMap<>();
        String contextBegin = contextList.get(beginIndex).trim();
        String labelBeginSign = "<" + label;
        String labelEndSign = "</" + label + ">";
        int labelBeginSignIndex = contextBegin.indexOf(labelBeginSign);
        if (labelBeginSignIndex < 0) {
            throw new RuntimeException("数据不匹配");
        }
        contextBegin = contextBegin.substring(labelBeginSignIndex);
        String labelBegin = contextBegin.substring(label.length() + 1, contextBegin.indexOf(">")).trim();
        if (labelBegin.length() > 0) {
            String[] keyValues = labelBegin.split(" ");
            for (String keyValue : keyValues) {
                String[] split = keyValue.split("=");
                result.put(split[0], Collections.singletonList(split[1]));
            }
        }
        List<String> value = new ArrayList<>();
        String contextMiddle = contextBegin.substring(contextBegin.indexOf(">") + 1);
        if (contextMiddle.length() > 0) {
            contextMiddle = contextMiddle.substring(0, contextMiddle.indexOf("<"));
            if (contextMiddle.length() > 0) {
                value.add(contextMiddle);
            }
        }
        int labelNum = 0;
        for (int i = beginIndex; i < contextList.size(); i++) {
            String context = contextList.get(i);
            labelNum += countWord(context, labelBeginSign);
            labelNum -= countWord(context, labelEndSign);
            if (labelNum <= 0) {
                break;
            }
            if (i != beginIndex) {
                value.add(context);
            }
        }
        result.put("VALUE", value);
        return result;

    }

    private static int countWord(String sourceStr, String targetStr) {
        int distance = sourceStr.indexOf(targetStr);
        if (distance < 0) {
            return 0;
        }
        int count = 1;
        count += countWord(sourceStr.substring(distance + targetStr.length()), targetStr);
        return count;
    }


}
