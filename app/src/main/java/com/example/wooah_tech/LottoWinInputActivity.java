package com.example.wooah_tech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wooah_tech.validate.ValidateCost;
import com.example.wooah_tech.validate.ValidateWinLotto;

import java.util.List;

public class LottoWinInputActivity extends AppCompatActivity {
    Button prevButton;
    Button nextButton;
    TextView costSelect;
    EditText winInput;
    TextView validateMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lotto_wininput);

        prevButton = (Button) findViewById(R.id.prevBtn);
        nextButton = (Button) findViewById(R.id.nextButton);
        costSelect = (TextView) findViewById(R.id.costSelect);
        winInput = (EditText) findViewById(R.id.winInput);
        validateMsg = (TextView) findViewById(R.id.validateMsg);

        Intent intentPrev = getIntent();
        int lottoCost = intentPrev.getIntExtra("lottoCost", 0);
        costSelect.setText(Integer.toString(lottoCost));

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LottoWinInputActivity.this, LottoCostInputActivity.class);
                startActivity(intent);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String winLottoStr = winInput.getText().toString();
                Intent intent = new Intent(LottoWinInputActivity.this, LottoBonusInputActivity.class);
                try {
                    List<Integer> winLotto = ValidateWinLotto.convertToList(winLottoStr);
                    ValidateWinLotto.validate(winLotto);
                    validateMsg.setText("");
                    intent.putExtra("lottoCost", lottoCost);
                    intent.putExtra("winLottoStr", winLottoStr);
                    startActivity(intent);
                } catch (IllegalArgumentException e) {
                    validateMsg.setText(e.getMessage());
                }
            }
        });
    }
}
