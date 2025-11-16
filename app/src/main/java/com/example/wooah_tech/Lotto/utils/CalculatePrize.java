package com.example.wooah_tech.Lotto.utils;

import java.util.List;

public class CalculatePrize {
    private static int lottoCorrect;
    private static boolean bonusCorrect;

    private CalculatePrize() {
    }

    private static void compareLotto(List<Integer> lottoNumbers, List<Integer> winLottoNumbers, int bonusNum) {
        lottoCorrect = 0;
        bonusCorrect = false;
        for (Integer num : lottoNumbers) {
            if (winLottoNumbers.contains(num)) {
                lottoCorrect += 1;
            } else if (num == bonusNum) {
                bonusCorrect = true;
            }
        }
    }

    public static int calculate(List<Integer> lottoNumbers, List<Integer> winLottoNumbers, int bonusNum) {
        compareLotto(lottoNumbers, winLottoNumbers, bonusNum);
        if (lottoCorrect == 6) {
            return 2000000000;
        }
        if (lottoCorrect == 5) {
            if (bonusCorrect) {
                return 300000000;
            }
            return 150000;
        }
        if (lottoCorrect == 4) {
            return 50000;
        }
        if (lottoCorrect == 3) {
            return 5000;
        }
        return 0;
    }
}
