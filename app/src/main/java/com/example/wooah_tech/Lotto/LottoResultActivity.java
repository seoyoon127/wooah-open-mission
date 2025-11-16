package com.example.wooah_tech.Lotto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wooah_tech.R;
import com.example.wooah_tech.Lotto.domain.Lottos;
import com.example.wooah_tech.Lotto.domain.Result;
import com.example.wooah_tech.Lotto.utils.WinResultUI;
import com.example.wooah_tech.Lotto.validate.ValidateWinLotto;

import java.util.List;

public class LottoResultActivity extends AppCompatActivity {
    TextView[]  balls;
    TextView resultMsg;
    LinearLayout myLottosList;
    Button endBtn;
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
        endBtn = findViewById(R.id.endBtn);

        Intent intentPrev = getIntent();
        int lottoCost = intentPrev.getIntExtra("lottoCost", 0);
        String winLottoStr = intentPrev.getStringExtra("winLottoStr");
        int bonus = intentPrev.getIntExtra("bonusNum",0);

        List<Integer> winLotto = ValidateWinLotto.convertToList(winLottoStr);
        WinResultUI.setWinLottoBallText(winLotto,bonus, balls);

        Lottos lottos = new Lottos(lottoCost/1000);
        Result result = new Result(lottos.getLottos(), winLotto,bonus);
        resultMsg.setText(result.getPrizeMsg());
        WinResultUI.setLottosUI(lottos, winLotto, bonus, this, myLottosList);

        endBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LottoResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
