package com.example.wooah_tech.Lotto.validate;

import java.util.List;

public class ValidateBonusNum {
    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;
    public static final int LottoSize = 6;
    public static final String RANGE_ERROR_MSG = "로또 번호는 1~45 사이입니다.";
    public static final String BONUS_INTEGER_ERROR_MSG = "보너스 번호는 숫자여야 합니다.";
    public static final String BONUS_DUPLICATE_ERROR_MSG = "당첨 번호와 겹쳐서는 안 됩니다.";

    public static int convertToInt(String bonusNum) {
        try {
            return Integer.parseInt(bonusNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_INTEGER_ERROR_MSG);
        }
    }

    public static void validate(int bonusNum, List<Integer> winNumbers) {
        validateRange(bonusNum);
        validateDuplicate(bonusNum, winNumbers);
    }

    public static void validateDuplicate(int bonusNum, List<Integer> winNumbers) {
        if (winNumbers.contains(bonusNum)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_ERROR_MSG);
        }
    }

    public static void validateRange(Integer number) {
        if (number < LOTTO_MIN || number > LOTTO_MAX) {
            throw new IllegalArgumentException(RANGE_ERROR_MSG);
        }
    }

}
