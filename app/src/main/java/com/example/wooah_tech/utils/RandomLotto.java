package com.example.wooah_tech.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RandomLotto {
    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;
    public static final int LottoSize = 6;
    public static List<Integer> generate() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        int size = 0;
        while (size != LottoSize){
            int newNum = random.nextInt(LOTTO_MAX) + LOTTO_MIN;
            if (!list.contains(newNum)){
                list.add(newNum);
                size += 1;
            }
        }
        return list;
    }
}