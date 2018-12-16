package com.example.neha.calc;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BinaryToDecimal extends AppCompatActivity {

    private Button back;
    private Button convert;
    private Button clear;

    private EditText binary;

    private TextView error;
    private TextView result;


    int decimal = 0;
    int length;
    int input;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_to_decimal);

        configure();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);


                text = binary.getText().toString();
                Log.i("BinaryToDecimal", "inside convert");
                if (binary.getText().toString().equals("")) {
                    Log.i("BTD, solve", "if statement");
                    error.setText("ERROR: Insert a value.");
                    result.setText(null);
                }
                else if(!text.matches("^[0-1_]+$")) {
                    Log.i("BinaryToDec", "else if");
                    error.setText("ERROR: Binary values may not contain digits besides 0 and 1.");
                    result.setText(null);
                }
                else {
                    Log.i("BinaryToDecimal convert", "else statement");

                    input = Integer.parseInt(binary.getText().toString());
                    Log.i("input = ", String.valueOf(input));

                    length = binary.getText().toString().length();
                    Log.i("length = ", String.valueOf(length));

                    int[] digits = new int[length];
                    for (int i = 0; i < length; i++) {
                        digits[i] = input % 10;
                        input = input / 10;
                        Log.i("digits[i]", String.valueOf(digits[i]));
                    }

                    for (int j = 0; j < length; j++) {
                        decimal += (int) (digits[j] * Math.pow(2, j));
                    }
                    Log.i("decimal = ", String.valueOf(decimal));

                    result.setText("Result: " + String.valueOf(decimal));
                    decimal = 0;
                    error.setText(null);
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binary.setText(null);
                result.setText(null);
                error.setText(null);
            }
        });
    }

    private void configure() {
        back = findViewById(R.id.back);
        convert = findViewById(R.id.convert);
        clear = findViewById(R.id.clear);

        binary = findViewById(R.id.binary);

        error = findViewById(R.id.error);
        result = findViewById(R.id.result);

    }
}