package com.example.wooah_tech.RacingCar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wooah_tech.R;
import com.example.wooah_tech.RacingCar.domain.Car;
import com.example.wooah_tech.RacingCar.domain.Cars;
import com.example.wooah_tech.RacingCar.util.CarService;
import com.example.wooah_tech.RacingCar.validate.ValidateCarNames;

import java.util.ArrayList;

public class RacingCarStartActivity extends AppCompatActivity {

    TextView roundInfo, carName1, carName2, carName3;
    ImageView carImage1, carImage2, carImage3;
    LinearLayout smoke1, smoke2, smoke3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.racingcar_gamestart);

        roundInfo = findViewById(R.id.roundInfo);
        carName1 = findViewById(R.id.carName1);
        carName2 = findViewById(R.id.carName2);
        carName3 = findViewById(R.id.carName3);

        carImage1 = findViewById(R.id.carImage1);
        carImage2 = findViewById(R.id.carImage2);
        carImage3 = findViewById(R.id.carImage3);

        smoke1 = findViewById(R.id.smokeSet1);
        smoke2 = findViewById(R.id.smokeSet2);
        smoke3 = findViewById(R.id.smokeSet3);

        Intent intentPrev = getIntent();
        String carName = intentPrev.getStringExtra("carName");
        int tryNum = intentPrev.getIntExtra("tryNum",0);


        Cars cars = new Cars(ValidateCarNames.convertToList(carName));
        setCarNames(cars);
        roundInfo.setText("Round 0\n");
        new Handler().postDelayed(() -> moveRounds(cars, tryNum, 0), 1500);
    }

    private void setCarNames(Cars cars) {
        TextView[] carNames = {carName1, carName2, carName3};
        ImageView[] carImages = {carImage1, carImage2, carImage3};
        for (int i = 0; i< cars.getCarList().size(); i++) {
            carNames[i].setText(cars.getCarList().get(i).getName());
        }
        for (int i= cars.getCarList().size(); i<3; i++){
            carNames[i].setText("");
            carImages[i].setVisibility(View.INVISIBLE);
        }
    }

    private void moveRounds(Cars cars, int tryNum, int round){
        ImageView[] carImages = {carImage1, carImage2, carImage3};
        LinearLayout[] smokeContainers = {smoke1, smoke2, smoke3};
        StringBuilder sb = new StringBuilder("Round "+(round+1)+"\n");
        if (round >= tryNum) {
                Intent intent = new Intent(RacingCarStartActivity.this, RacingCarResultLoadingActivity.class);
                intent.putExtra("winnerList", new ArrayList<>(cars.getWinners()));
                intent.putExtra("winIndexList", new ArrayList<>(cars.getWinIndex()));
                intent.putExtra("resultMap", cars.getCarDistanceMap());
                startActivity(intent);
                finish();
                return;
        }
        for (int i=0;i<cars.getCarList().size();i++){
            Car car = cars.getCarList().get(i);
            int prev = car.getDistance();
            car.move();
            sb.append(car.getName() + ": " + car.getDistance() + " ");
            if (prev+1==car.getDistance()){
                CarService.moveCar(carImages[i], smokeContainers[i], car.getDistance(), this);
            }
        }
        roundInfo.setText(sb);
        // 다음 라운드 500ms 후 실행
        new Handler().postDelayed(() -> moveRounds(cars, tryNum, round+1), 1500);
    }


}
