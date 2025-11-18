package com.example.wooah_tech.RacingCar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wooah_tech.Lotto.LottoLoadingActivity;
import com.example.wooah_tech.R;
import com.example.wooah_tech.RacingCar.validate.ValidateTry;

public class RacingCarTryInputActivity extends AppCompatActivity {
    Button prevButton;
    Button nextButton;
    TextView nameSelect;
    EditText tryInput;
    TextView validateMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.racingcar_tryinput);

        prevButton = (Button) findViewById(R.id.prevBtn);
        nextButton = (Button) findViewById(R.id.nextButton);
        nameSelect = (TextView) findViewById(R.id.nameSelect);
        tryInput = (EditText) findViewById(R.id.tryInput);
        validateMsg = (TextView) findViewById(R.id.validateMsg);

        Intent intentPrev = getIntent();
        String carName = intentPrev.getStringExtra("carName");
        nameSelect.setText(carName);


        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RacingCarTryInputActivity.this, RacingCarNameInputActivity.class);
                startActivity(intent);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tryStr = tryInput.getText().toString();
                Intent intent = new Intent(RacingCarTryInputActivity.this, RacingCarStartLoadingActivity.class);
                try {
                    int tryNum = ValidateTry.convertToInt(tryStr);
                    ValidateTry.validate(tryNum);
                    validateMsg.setText("");
                    intent.putExtra("carName", carName);
                    intent.putExtra("tryNum", tryNum);
                    startActivity(intent);
                } catch (IllegalArgumentException e) {
                    validateMsg.setText(e.getMessage());
                }
            }
        });
    }
}
