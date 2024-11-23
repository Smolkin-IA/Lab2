package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText firstValueEdit;
    private EditText secondValueEdit;
    private EditText resultEdit;
    private TextView operatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firstValueEdit = findViewById(R.id.first_value);
        secondValueEdit = findViewById(R.id.second_value);
        resultEdit = findViewById(R.id.result);
        operatorView = findViewById(R.id.operator);

        Button calculateButton = findViewById(R.id.calculate_btn);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double fistValue = Double.parseDouble(firstValueEdit.getText().toString());
                double secondValue = Double.parseDouble(secondValueEdit.getText().toString());
                String operator = operatorView.getText().toString();
                double result = 0;

                try{
                    switch (operator){
                        case ("+"):
                            result = fistValue + secondValue;
                            break;
                        case ("-"):
                            result = fistValue - secondValue;
                            break;
                        case ("*"):
                            result = fistValue * secondValue;
                            break;
                        case ("/"):
                            result = fistValue / secondValue;
                            break;
                    }

                    resultEdit.setText(String.valueOf(result));
                }catch (NumberFormatException e){
                    Toast.makeText(
                            MainActivity.this,
                            "Введите корректные значения",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });

        Button clearBtn = findViewById(R.id.clear_btn);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstValueEdit.setText("");
                secondValueEdit.setText("");
                resultEdit.setText("");
            }
        });
    }

    public void onOperatorBtnClick (View v){
        operatorView.setText(((Button)v).getText().toString());
    }
}