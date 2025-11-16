package com.example.wooah_tech.Lotto.validate;

public class ValidateCost {
    public static final int COST_UNIT = 1000;
    public static final String COST_INTEGER_ERROR_MSG = "구매 금액은 숫자여야 합니다.";
    public static final String COST_POSITIVE_ERROR_MSG = "구입 금액은 양수여야 합니다.";
    public static final String COST_UNIT_ERROR_MSG = "구매 금액은 1000 단위여야 합니다.";
    public static int convertToInt(String bonusNum) {
        try {
            return Integer.parseInt(bonusNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(COST_INTEGER_ERROR_MSG);
        }
    }

    public static void validate(int lottoCost) {
        validateIsPositive(lottoCost);
        validateUnit(lottoCost);
    }

    public static void validateIsPositive(int lottoCost) {
        if (lottoCost < 0) {
            throw new IllegalArgumentException(COST_POSITIVE_ERROR_MSG);
        }
    }

    public static void validateUnit(int lottoCost) {
        if (lottoCost % COST_UNIT != 0) {
            throw new IllegalArgumentException(COST_UNIT_ERROR_MSG);
        }
    }
}
