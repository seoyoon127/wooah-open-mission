package com.example.wooah_tech.Lotto.utils;

public class BallColor {
    public static String getColor(int num){
        if (num < 10){
            return "#F7D033";
        } else if (num < 20){
            return "#407FF5";
        } else if (num < 30){
            return "#F11F43";
        } else if (num < 40){
            return "#CCCCCC";
        } else {
            return "#87D50F";
        }
    }
}
