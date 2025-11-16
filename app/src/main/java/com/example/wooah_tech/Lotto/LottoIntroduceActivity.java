package com.example.wooah_tech.Lotto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wooah_tech.R;

public class LottoIntroduceActivity extends AppCompatActivity {

    Button prevButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lotto_introduce);

        prevButton = (Button) findViewById(R.id.prevBtn);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LottoIntroduceActivity.this, LottoMainActivity.class);
                startActivity(intent);
            }
        });
    }
}
