package com.example.wooah_tech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wooah_tech.validate.ValidateCost;

public class LottoCostInputActivity extends AppCompatActivity {
    Button prevButton;
    Button nextButton;
    EditText costInput;
    TextView validateMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lotto_costinput);

        prevButton = (Button) findViewById(R.id.prevBtn);
        nextButton = (Button) findViewById(R.id.nextButton);
        costInput = (EditText) findViewById(R.id.costInput);
        validateMsg = (TextView) findViewById(R.id.validateMsg);

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LottoCostInputActivity.this, LottoMainActivity.class);
                startActivity(intent);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputCostStr = costInput.getText().toString();
                Intent intent = new Intent(LottoCostInputActivity.this, LottoWinInputActivity.class);
                try{
                    int inputCost = ValidateCost.convertToInt(inputCostStr);
                    ValidateCost.validate(inputCost);
                    validateMsg.setText("");
                    intent.putExtra("lottoCost", inputCost);
                    startActivity(intent);
                } catch (IllegalArgumentException e){
                    validateMsg.setText(e.getMessage());
                }
            }
        });
    }
}
