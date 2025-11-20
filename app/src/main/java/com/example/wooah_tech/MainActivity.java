package com.example.wooah_tech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wooah_tech.Calculator.CalculatorMainActivity;
import com.example.wooah_tech.Lotto.LottoMainActivity;
import com.example.wooah_tech.R;
import com.example.wooah_tech.RacingCar.RacingCarMainActivity;

public class MainActivity extends AppCompatActivity {

    Button lottoBtn;
    Button racingcarBtn;
    Button calculatorBtn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottoBtn = (Button) findViewById(R.id.lottoBtn);
        racingcarBtn = (Button) findViewById(R.id.racingcarBtn);
        calculatorBtn = (Button) findViewById(R.id.calculatorBtn);

        lottoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LottoMainActivity.class);
                startActivity(intent);
            }
        });

        racingcarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RacingCarMainActivity.class);
                startActivity(intent);
            }
        });

        calculatorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalculatorMainActivity.class);
                startActivity(intent);
            }
        });
    }
}