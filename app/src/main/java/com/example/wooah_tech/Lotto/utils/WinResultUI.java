package com.example.wooah_tech.Lotto.utils;

import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wooah_tech.Lotto.domain.Lotto;
import com.example.wooah_tech.Lotto.domain.Lottos;

import java.util.List;

public class WinResultUI {
    public static void setWinLottoBallText(List<Integer> winNumbers, int bonus, TextView[] balls){
        for (int i = 0; i < balls.length; i++) {
            int number = i == 6 ? bonus : winNumbers.get(i);
            balls[i].setText(String.valueOf(number));
            balls[i].setTextColor(Color.parseColor("#FFFFFF"));
            balls[i].getBackground().setTint(Color.parseColor(BallColor.getColor(number)));
        }
    }

    public static void setLottosUI(Lottos allLottos, List<Integer> winNumbers, int bonus, AppCompatActivity activity, LinearLayout myLottosList){
        char label = 'A';
        for (Lotto lotto : allLottos.getLottos()) {
            LinearLayout row = new LinearLayout(activity);
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setGravity(Gravity.CENTER);

            // 1. 로또 개수 라벨(알파벳 표기)
            MyResultUI.setMyLottoLabel(label,row, activity);
            label++;

            // 2. 당첨 결과
            MyResultUI.setMyLottoResult(lotto, row, winNumbers, bonus, activity);

            // 3. 로또 번호 표시
            MyResultUI.setMyLottoNumber(lotto, row, winNumbers, activity);

            myLottosList.addView(row);
        }
    }
}
