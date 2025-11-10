package com.example.wooah_tech;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LottoResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lotto_result);

        Intent intentPrev = getIntent();
        int lottoCost = intentPrev.getIntExtra("lottoCost", 0);
        String winLottoStr = intentPrev.getStringExtra("winLottoStr");
        int bonus = intentPrev.getIntExtra("bonusNum",0);
    }
}
