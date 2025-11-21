package com.example.wooah_tech.Calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wooah_tech.MainActivity;
import com.example.wooah_tech.R;

public class CalculatorMainActivity extends AppCompatActivity {

    Button calculatorIntroduceBtn;
    Button calculatorPrecautionBtn;
    Button calculatorStartBtn;
    Button prevButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_main);

        calculatorIntroduceBtn = (Button) findViewById(R.id.introduceBtn);
        calculatorPrecautionBtn = (Button) findViewById(R.id.precautionBtn);
        calculatorStartBtn = (Button) findViewById(R.id.startBtn);
        prevButton = (Button) findViewById(R.id.prevBtn);

        calculatorIntroduceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalculatorMainActivity.this, CalculatorIntroduceActivity.class);
                startActivity(intent);
            }
        });

        calculatorPrecautionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalculatorMainActivity.this, CalculatorPrecautionActivity.class);
                startActivity(intent);
            }
        });

        calculatorStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalculatorMainActivity.this, CalculatorInputActivity.class);
                startActivity(intent);
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalculatorMainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}