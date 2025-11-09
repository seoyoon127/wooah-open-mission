package com.example.wooah_tech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LottoMainActivity extends AppCompatActivity {

    Button lottoIntroduceBtn;
    Button lottoPrecautionBtn;
    Button lottoStartBtn;
    Button prevButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lotto_main);

        lottoIntroduceBtn = (Button) findViewById(R.id.introduceBtn);
        lottoPrecautionBtn = (Button) findViewById(R.id.precautionBtn);
        lottoStartBtn = (Button) findViewById(R.id.startBtn);
        prevButton = (Button) findViewById(R.id.prevBtn);

        lottoIntroduceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LottoMainActivity.this, LottoIntroduceActivity.class);
                startActivity(intent);
            }
        });

        lottoPrecautionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LottoMainActivity.this, LottoPrecautionActivity.class);
                startActivity(intent);
            }
        });

        lottoStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LottoMainActivity.this, LottoCostInputActivity.class);
                startActivity(intent);
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LottoMainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}