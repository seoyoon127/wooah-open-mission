package com.example.wooah_tech.RacingCar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wooah_tech.R;

public class RacingCarResultLoadingActivity extends AppCompatActivity {
    private static final int SPLASH_TIMEOUT = 2000;
    private static final int IMAGE_CHANGE_INTERVAL = 400;
    private ImageView loadingImage;
    private Handler handler = new Handler();
    private int[] images = {
            R.drawable.red_car,
            R.drawable.blue_car,
            R.drawable.green_car
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
        setContentView(R.layout.racingcar_resultloading);

        loadingImage = findViewById(R.id.carIcon);
        handler.post(imageChanger);

        handler.postDelayed(new Runnable() {
            @Override
            public void run(){
                Intent prevIntent = getIntent();
                Intent intent = new Intent(RacingCarResultLoadingActivity.this, RacingCarResultActivity.class);
                if (prevIntent.getExtras() != null) {
                    intent.putExtras(prevIntent.getExtras());
                }
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIMEOUT);
    }
}
