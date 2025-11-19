package com.example.wooah_tech.RacingCar.util;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wooah_tech.R;

public class CarService {
    public static void moveCar(ImageView car, LinearLayout smokeContainer, int stepSize, AppCompatActivity activity){

        // 연기 생성
        ImageView smoke = new ImageView(activity);
        smoke.setImageResource(R.drawable.smoke);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(100, 100);
        params.setMargins(5,0,5,0);
        smoke.setLayoutParams(params);
        smokeContainer.addView(smoke, 0); // 왼쪽에 추가

        // 차 이동 애니메이션
        car.animate()
                .translationXBy(stepSize)
                .setDuration(300)
                .start();
    }
}
