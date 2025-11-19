package com.example.wooah_tech.RacingCar.validate;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ValidateCarNames {
    public static final String delimiter = ",";
    public static final int CAR_MAX = 3;
    public static final int CAR_MIN = 2;
    public static final int CAR_NAME_MAX = 5;
    public static final String CAR_LENGTH_ERROR_MSG = "자동차 이름은 5글자 이하여야 합니다.";
    public static final String CAR_SIZE_ERROR_MSG = "자동차는 최대 3개까지 가능합니다.";
    public static final String CAR_MIN_ERROR_MSG = "자동차는 최소 2대 이상이어야 합니다.";
    public static final String CAR_DUPLICATE_ERROR_MSG = "중복된 이름이 있어선 안 됩니다.";

    public static List<String> convertToList(String lottoInput) {
        return Arrays.asList(lottoInput.split(delimiter));
    }

    public static void validate(List<String> names) {
        validateCarSize(names.size());
        validateDuplicate(names);
        validateNameLength(names);
    }

    public static void validateCarSize(Integer size) {
        if (size > CAR_MAX) {
            throw new IllegalArgumentException(CAR_SIZE_ERROR_MSG);
        }
        else if (size < CAR_MIN){
            throw new IllegalArgumentException(CAR_MIN_ERROR_MSG);
        }
    }

    public static void validateDuplicate(List<String> names) {
        if (new HashSet<>(names).size() != names.size()) {
            throw new IllegalArgumentException(CAR_DUPLICATE_ERROR_MSG);
        }
    }

    public static void validateNameLength(List<String> names) {
        for (String name : names){
            if (name.length() > CAR_NAME_MAX){
                throw new IllegalArgumentException(CAR_LENGTH_ERROR_MSG);
            }
        }
    }
}
