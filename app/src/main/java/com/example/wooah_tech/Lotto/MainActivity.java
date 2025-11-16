package com.example.wooah_tech.Lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wooah_tech.R;

public class MainActivity extends AppCompatActivity {

    Button lottoBtn;
    //Button racingcarBtn;
    //Button calculatorBtn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottoBtn = (Button) findViewById(R.id.lottoBtn);
        //racingcarBtn = (Button) findViewById(R.id.racingcarBtn);
        //calculatorBtn = (Button) findViewById(R.id.calculatorBtn);

        lottoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LottoMainActivity.class);
                startActivity(intent);
            }
        });
    }
}