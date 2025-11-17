package com.example.wooah_tech.RacingCar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wooah_tech.MainActivity;
import com.example.wooah_tech.R;

public class RacingCarMainActivity extends AppCompatActivity {
    Button racingcarIntroduceBtn;
    Button racingcarPrecautionBtn;
    Button racingcarStartBtn;
    Button prevButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.racingcar_main);

        racingcarIntroduceBtn = (Button) findViewById(R.id.introduceBtn);
        racingcarPrecautionBtn = (Button) findViewById(R.id.precautionBtn);
        racingcarStartBtn = (Button) findViewById(R.id.startBtn);
        prevButton = (Button) findViewById(R.id.prevBtn);

        racingcarIntroduceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RacingCarMainActivity.this, RacingCarIntroduceActivity.class);
                startActivity(intent);
            }
        });

        racingcarPrecautionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RacingCarMainActivity.this, RacingCarPrecautionActivity.class);
                startActivity(intent);
            }
        });

        racingcarStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RacingCarMainActivity.this,RacingCarNameInputActivity.class);
                startActivity(intent);
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RacingCarMainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
