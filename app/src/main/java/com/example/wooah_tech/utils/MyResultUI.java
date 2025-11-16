package com.example.wooah_tech.utils;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wooah_tech.R;
import com.example.wooah_tech.domain.Lotto;

import java.util.List;

public class MyResultUI {
    public static void setMyLottoLabel(char label, LinearLayout row, AppCompatActivity activity){
        TextView labelView = new TextView(activity);
        labelView.setText(label + " ");
        labelView.setTextSize(18);
        LinearLayout.LayoutParams labelParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        labelParams.setMargins(10, 0, 20, 0);
        labelView.setLayoutParams(labelParams);
        row.addView(labelView);
    }

    public static void setMyLottoResult(Lotto lotto, LinearLayout row, List<Integer> winNumbers, int bonus, AppCompatActivity activity){
        TextView resultView = new TextView(activity);
        boolean isWin = CalculatePrize.calculate(lotto.getLotto(), winNumbers, bonus) != 0;
        resultView.setText(isWin ? "당첨" : "낙첨");
        resultView.setTextSize(16);
        resultView.setTextColor(isWin ? Color.RED : Color.GRAY);
        LinearLayout.LayoutParams resultParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        resultParams.setMargins(20, 0, 20, 0);
        resultView.setLayoutParams(resultParams);
        row.addView(resultView);
    }

    public static void setMyLottoNumber(Lotto lotto, LinearLayout row, List<Integer> winNumbers, AppCompatActivity activity){
        LinearLayout.LayoutParams rowParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        rowParams.setMargins(0, 10, 0, 10);
        row.setLayoutParams(rowParams);

        setMyLottoBall(lotto, winNumbers, row, activity);
    }

    public static void setMyLottoBall(Lotto lotto, List<Integer> winNumbers, LinearLayout row, AppCompatActivity activity){
        for (int num : lotto.getLotto()) {
            TextView ball = (TextView) activity.getLayoutInflater().inflate(R.layout.lotto_ball, row, false);
            ball.setText(String.valueOf(num));

            Drawable background = ball.getBackground().mutate();
            if (winNumbers.contains(num)){
                ball.setTextColor(Color.parseColor("#FFFFFF"));
                background.setTint(Color.parseColor(BallColor.getColor(num)));
            } else{
                background.setTint(Color.parseColor("#FFFFFF"));
            }
            ball.setBackground(background);

            row.addView(ball);
        }
    }
}