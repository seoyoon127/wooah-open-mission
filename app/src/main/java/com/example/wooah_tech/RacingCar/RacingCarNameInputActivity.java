package com.example.wooah_tech.RacingCar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.wooah_tech.R;
import com.example.wooah_tech.RacingCar.validate.ValidateCarNames;

import java.util.List;

public class RacingCarNameInputActivity extends AppCompatActivity {
    Button prevButton;
    Button nextButton;
    EditText nameInput;
    TextView validateMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.racingcar_nameinput);

        prevButton = (Button) findViewById(R.id.prevBtn);
        nextButton = (Button) findViewById(R.id.nextButton);
        nameInput = (EditText) findViewById(R.id.nameInput);
        validateMsg = (TextView) findViewById(R.id.validateMsg);

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RacingCarNameInputActivity.this, RacingCarMainActivity.class);
                startActivity(intent);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputCarName = nameInput.getText().toString();
                Intent intent = new Intent(RacingCarNameInputActivity.this, RacingCarTryInputActivity.class);
                try{
                    List<String> carName = ValidateCarNames.convertToList(inputCarName);
                    ValidateCarNames.validate(carName);
                    validateMsg.setText("");
                    intent.putExtra("carName", inputCarName);
                    startActivity(intent);
                } catch (IllegalArgumentException e){
                    validateMsg.setText(e.getMessage());
                }
            }
        });
    }
}
