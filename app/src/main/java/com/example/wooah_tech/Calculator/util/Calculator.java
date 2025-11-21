package com.example.wooah_tech.Calculator.util;

import android.util.Log;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.*?)(\\n|\\\\n)");
    private static final String CALCULATOR_INTEGER_ERROR_MSG = "문자열은 더할 수 없습니다.";

    public static Integer sum(String str){
        String sumString = replaceCustomSeparator(replaceBasicSeparator(str));
        List<Integer> sumList = convertToList(sumString);
        return sumList.stream()
                .reduce(0, Integer::sum);
    }

    public static List<Integer> convertToList(String calculateStr) {
        try {
            return Arrays.stream(calculateStr.split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CALCULATOR_INTEGER_ERROR_MSG);
        }
    }
    public static String replaceBasicSeparator(String str){
        return str.replace(":",",");
    }
    public static String replaceCustomSeparator(String str){
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(str);
        while (matcher.find()){
            String customS = matcher.group(1);
            Log.d("customS",customS);
            str = str.replace(matcher.group(0), ",").replace(customS, ",");
        }
        Log.d("custom",str);
        return str ;
    }
}
