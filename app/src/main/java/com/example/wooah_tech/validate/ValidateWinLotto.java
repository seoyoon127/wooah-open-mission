package com.example.wooah_tech.validate;

import android.util.Log;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ValidateWinLotto {
    public static final String delimiter = ",";
    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;
    public static final int LottoSize = 6;
    public static final String LOTTO_INTEGER_ERROR_MSG = "로또 번호는 숫자로 작성해야 합니다.";
    public static final String LOTTO_SIZE_ERROR_MSG = "로또 번호는 6개여야 합니다.";
    public static final String LOTTO_DUPLICATE_ERROR_MSG = "로또에 중복 번호가 있어선 안 됩니다.";
    public static final String RANGE_ERROR_MSG = "로또 번호는 1~45 사이입ㄴ니다.";

    public static List<Integer> convertToList(String lottoInput) {
        try {
            return Arrays.stream(lottoInput.split(delimiter))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LOTTO_INTEGER_ERROR_MSG);
        }
    }

    public static void validate(List<Integer> numbers) {
        validateLottoSize(numbers.size());
        validateDuplicate(numbers);
        validateNumbersRange(numbers);
    }

    public static void validateLottoSize(Integer size) {
        Log.d("DEBUG", "lottoSize=" + size);
        if (size != LottoSize) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR_MSG);
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LottoSize) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_ERROR_MSG);
        }
    }

    public static void validateNumbersRange(List<Integer> numbers) {
        for (int number:numbers){
            if (number < LOTTO_MIN || number > LOTTO_MAX) {
                throw new IllegalArgumentException(RANGE_ERROR_MSG);
            }
        }
    }
}
