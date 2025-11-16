package com.example.wooah_tech;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wooah_tech.domain.Lotto;
import com.example.wooah_tech.domain.Lottos;
import com.example.wooah_tech.domain.Result;
import com.example.wooah_tech.utils.BallColor;
import com.example.wooah_tech.utils.ResultUI;
import com.example.wooah_tech.validate.ValidateWinLotto;

import java.util.List;

public class LottoResultActivity extends AppCompatActivity {
    TextView[]  balls;
    TextView resultMsg;
    LinearLayout myLottosList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lotto_result);

        balls = new  TextView[] {
                findViewById(R.id.ball1),
                findViewById(R.id.ball2),
                findViewById(R.id.ball3),
                findViewById(R.id.ball4),
                findViewById(R.id.ball5),
                findViewById(R.id.ball6),
                findViewById(R.id.ballBonus)
        };
        resultMsg = findViewById(R.id.resultMsgText);
        myLottosList = findViewById(R.id.myLottosList);
        myLottosList.removeAllViews();


        Intent intentPrev = getIntent();
        int lottoCost = intentPrev.getIntExtra("lottoCost", 0);
        String winLottoStr = intentPrev.getStringExtra("winLottoStr");
        int bonus = intentPrev.getIntExtra("bonusNum",0);

        List<Integer> winLotto = ValidateWinLotto.convertToList(winLottoStr);
        setWinLottoBallText(winLotto,bonus);

        Lottos lottos = new Lottos(lottoCost/1000);
        Result result = new Result(lottos.getLottos(), winLotto,bonus);
        resultMsg.setText(result.getPrizeMsg());
        setLottosUI(lottos, winLotto, bonus);

    }

    private void setWinLottoBallText(List<Integer> winNumbers, int bonus){
        for (int i = 0; i < balls.length; i++) {
            int number = i == 6 ? bonus : winNumbers.get(i);
            balls[i].setText(String.valueOf(number));
            balls[i].setTextColor(Color.parseColor("#FFFFFF"));
            balls[i].getBackground().setTint(Color.parseColor(BallColor.getColor(number)));
        }
    }

    private void setLottosUI(Lottos allLottos, List<Integer> winNumbers, int bonus){
        char label = 'A';
        for (Lotto lotto : allLottos.getLottos()) {
            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setGravity(Gravity.CENTER);

            // 1. 로또 개수 라벨(알파벳 표기)
            ResultUI.setMyLottoLabel(label,row, this);
            label++;

            // 2. 당첨 결과
            ResultUI.setMyLottoResult(lotto, row, winNumbers, bonus, this);

            // 3. 로또 번호 표시
            ResultUI.setMyLottoNumber(lotto, row, winNumbers, this);

            myLottosList.addView(row);
        }
    }
}
