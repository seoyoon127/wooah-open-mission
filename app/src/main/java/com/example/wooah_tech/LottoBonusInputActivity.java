package com.example.wooah_tech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wooah_tech.validate.ValidateBonusNum;
import com.example.wooah_tech.validate.ValidateWinLotto;

import java.util.List;

public class LottoBonusInputActivity extends AppCompatActivity {
    Button prevButton;
    Button nextButton;
    TextView costSelect;
    TextView winSelect;
    EditText bonusInput;
    TextView validateMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lotto_bonusinput);

        prevButton = (Button) findViewById(R.id.prevBtn);
        nextButton = (Button) findViewById(R.id.nextButton);
        costSelect = (TextView) findViewById(R.id.costSelect);
        winSelect = (TextView) findViewById(R.id.winSelect);
        bonusInput = (EditText) findViewById(R.id.bonusInput);
        validateMsg = (TextView) findViewById(R.id.validateMsg);

        Intent intentPrev = getIntent();
        int lottoCost = intentPrev.getIntExtra("lottoCost", 0);
        String winLottoStr = intentPrev.getStringExtra("winLottoStr");
        costSelect.setText(Integer.toString(lottoCost));
        winSelect.setText(winLottoStr);


        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LottoBonusInputActivity.this, LottoWinInputActivity.class);
                intent.putExtra("lottoCost", lottoCost);
                startActivity(intent);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bonusStr = bonusInput.getText().toString();
                Intent intent = new Intent(LottoBonusInputActivity.this, LottoLoadingActivity.class);
                try {
                    int bonus = ValidateBonusNum.convertToInt(bonusStr);
                    ValidateBonusNum.validate(bonus, ValidateWinLotto.convertToList(winLottoStr));
                    validateMsg.setText("");
                    intent.putExtra("lottoCost", lottoCost);
                    intent.putExtra("winLottoStr", winLottoStr);
                    intent.putExtra("bonusNum", bonus);
                    startActivity(intent);
                } catch (IllegalArgumentException e) {
                    validateMsg.setText(e.getMessage());
                }
            }
        });
    }
}
