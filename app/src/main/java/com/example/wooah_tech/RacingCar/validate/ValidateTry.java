package com.example.wooah_tech.RacingCar.validate;

import java.util.List;

public class ValidateTry {
    public static final int TRY_MAX = 10;
    public static final String TRY_MAX_ERROR_MSG = "최대 10회 실행할 수 있습니다.";
    public static final String TRY_INTEGER_ERROR_MSG = "실행횟수는 숫자여야 합니다.";

    public static int convertToInt(String tryNum) {
        try {
            return Integer.parseInt(tryNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_INTEGER_ERROR_MSG);
        }
    }

    public static void validate(int tryNum) {
        validateMax(tryNum);
    }

    public static void validateMax(int tryNum) {
        if (tryNum > TRY_MAX) {
            throw new IllegalArgumentException(TRY_MAX_ERROR_MSG);
        }
    }
}
