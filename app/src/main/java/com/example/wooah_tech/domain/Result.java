package com.example.wooah_tech.domain;

import com.example.wooah_tech.utils.CalculatePrize;

import java.util.List;

public class Result {
    private int prize = 0;
    private static String WIN_MSG = "축하합니다!\n총  %,d원 당첨";
    private static String LOSE_MSG = "아쉽게도,\n낙첨되었습니다.";
    public Result(List<Lotto> lottos, List<Integer> winLotto, int bonusNum) {
        for (Lotto lotto : lottos) {
            prize += CalculatePrize.calculate(lotto.getLotto(),winLotto, bonusNum);
        }
    }
    public String getPrizeMsg(){
        if (prize == 0){
            return LOSE_MSG;
        }
        return String.format(WIN_MSG, prize);
    }
}
