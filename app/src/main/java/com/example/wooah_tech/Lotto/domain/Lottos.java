package com.example.wooah_tech.Lotto.domain;

import com.example.wooah_tech.Lotto.utils.RandomLotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int size) {
        lottos = makeLottos(size);
    }

    private List<Lotto> makeLottos(int size) {
        List<Lotto> newLottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Lotto lotto = new Lotto(RandomLotto.generate());
            newLottos.add(lotto);
        }
        return newLottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
