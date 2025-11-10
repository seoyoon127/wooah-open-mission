package com.example.wooah_tech;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class LottoLoadingActivity extends AppCompatActivity {
    private static final int SPLASH_TIMEOUT = 2000;
    private static final int IMAGE_CHANGE_INTERVAL = 500;
    private ImageView loadingImage;
    private Handler handler = new Handler();
    private int[] images = {
            R.drawable.lotto1,
            R.drawable.lotto2,
            R.drawable.lotto3
    };
    private int currentIndex = 0;

    private Runnable imageChanger = new Runnable() {
        @Override
        public void run() {
            loadingImage.setImageResource(images[currentIndex]);
            currentIndex = (currentIndex + 1) % images.length;
            handler.postDelayed(this, IMAGE_CHANGE_INTERVAL);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lotto_loading);

        loadingImage = findViewById(R.id.lottoIcon);
        handler.post(imageChanger);


        Intent intentPrev = getIntent();
        int lottoCost = intentPrev.getIntExtra("lottoCost", 0);
        String winLottoStr = intentPrev.getStringExtra("winLottoStr");
        int bonus = intentPrev.getIntExtra("bonusNum",0);

        handler.postDelayed(new Runnable() {
            @Override
            public void run(){
                Intent intent = new Intent(LottoLoadingActivity.this, LottoResultActivity.class);
                intent.putExtra("lottoCost", lottoCost);
                intent.putExtra("winLottoStr", winLottoStr);
                intent.putExtra("bonusNum", bonus);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIMEOUT);
    }
}
