package com.example.wooah_tech.RacingCar;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wooah_tech.MainActivity;
import com.example.wooah_tech.R;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingCarResultActivity extends AppCompatActivity {

    TextView winnerMsg;
    LinearLayout winCarImg;
    TextView resultInfo;
    Button endBtn;
    private int[] images = {
            R.drawable.red_car,
            R.drawable.blue_car,
            R.drawable.green_car
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.racingcar_result);

        winnerMsg = findViewById(R.id.winnerMsg);
        winCarImg = findViewById(R.id.winCarImg);
        resultInfo = findViewById(R.id.resultInfo);
        endBtn = findViewById(R.id.endBtn);

        Intent prevIntent = getIntent();
        List<String> winnerList = prevIntent.getStringArrayListExtra("winnerList");
        List<Integer> winIndexList = prevIntent.getIntegerArrayListExtra("winIndexList");
        HashMap<String, Integer> result = (HashMap<String, Integer>) getIntent().getSerializableExtra("resultMap");

        setWinnerMsg(winnerList);
        setImages(winIndexList);
        setResultInfo(result);

        endBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RacingCarResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setWinnerMsg(List<String> winnerList) {
        winnerMsg.setText("우승자는 "+ winnerList.stream().collect(Collectors.joining("님, "))+ "님입니다.");
    }

    private void setResultInfo(HashMap<String, Integer> result) {
        StringBuilder sb = new StringBuilder("~결과~\n");
        LinkedHashMap<String, Integer> sortedResult = new LinkedHashMap<>();
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(e -> sortedResult.put(e.getKey(), e.getValue()));
        int rank = 1;
        for (Map.Entry<String, Integer> entry : sortedResult.entrySet()){
            sb.append(rank + "위: " + entry.getKey() + " (" + entry.getValue() + "칸 이동)\n");
            rank += 1;
        }
        resultInfo.setText(sb);
    }

    private void setImages(List<Integer> winIndexList) {
        int imgSize = dpToPx(100);
        winIndexList.stream().forEach(i -> {
            System.out.println(i);
            ImageView img = new ImageView(this);
            img.setImageResource(images[i]);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(imgSize, imgSize);
            params.setMargins(5,0,5,0);
            img.setLayoutParams(params);
            winCarImg.addView(img);
        });
    }

    int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5f);
    }
}
