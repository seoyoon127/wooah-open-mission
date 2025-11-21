package com.example.wooah_tech.Calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wooah_tech.Calculator.util.Calculator;
import com.example.wooah_tech.Lotto.LottoResultActivity;
import com.example.wooah_tech.Lotto.LottoWinInputActivity;
import com.example.wooah_tech.Lotto.validate.ValidateCost;
import com.example.wooah_tech.MainActivity;
import com.example.wooah_tech.R;

public class CalculatorInputActivity extends AppCompatActivity {
    Button prevButton;
    Button endButton, checkButton;
    EditText calculateInput;
    TextView validateMsg, resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_input);

        prevButton = (Button) findViewById(R.id.prevBtn);
        endButton = (Button) findViewById(R.id.endBtn);
        checkButton = (Button) findViewById(R.id.checkButton);
        calculateInput = (EditText) findViewById(R.id.calculateInput);
        validateMsg = (TextView) findViewById(R.id.validateMsg);
        resultText = (TextView) findViewById(R.id.resultText);

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalculatorInputActivity.this, CalculatorMainActivity.class);
                startActivity(intent);
            }
        });

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String calculateStr = calculateInput.getText().toString();
                try{
                    int result = Calculator.sum(calculateStr);
                    validateMsg.setText("");
                    resultText.setText("결과: "+result);
                } catch (IllegalArgumentException e){
                    validateMsg.setText(e.getMessage());
                }
            }
        });

        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalculatorInputActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
