package com.example.wooah_tech.domain;

import com.example.wooah_tech.validate.ValidateWinLotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        ValidateWinLotto.validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLotto() {
        return numbers;
    }
}
