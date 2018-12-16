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

public class FourFunctionCalculator extends AppCompatActivity {

    private Button add;
    private Button subtract;
    private Button multiply;
    private Button divide;
    private Button clear;
    private Button back;

    private EditText first;
    private EditText second;

    private TextView error;
    private TextView result;

    private double val1;
    private double val2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_function_calculator);

        configure();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                Log.i("add", "inside add");
                if (first.getText().toString().equals("") || second.getText().toString().equals("")) {
                    Log.i("add", "if statement");
                    error.setText("ERROR: Insert values for both numbers.");
                    result.setText(null);
                } else {
                    Log.i("add", "else statement");
                    val1 = Double.parseDouble(first.getText().toString());
                    val2 = Double.parseDouble(second.getText().toString());
                    result.setText(String.valueOf(val1 + val2));
                    error.setText(null);
                }
            }
        });


        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                Log.i("subtract", "inside subtract");
                if (first.getText().toString().equals("") || second.getText().toString().equals("")) {
                    Log.i("subtract", "if statement");
                    error.setText("ERROR: Insert values for both numbers.");
                    result.setText(null);
                } else {
                    Log.i("subtract", "else statement");
                    val1 = Double.parseDouble(first.getText().toString());
                    val2 = Double.parseDouble(second.getText().toString());
                    result.setText(String.valueOf(val1 - val2));
                    error.setText(null);
                }
            }
        });


        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                Log.i("multiply", "inside multiply");
                if (first.getText().toString().equals("") || second.getText().toString().equals("")) {
                    Log.i("multiply", "if statement");
                    error.setText("ERROR: Insert values for both numbers.");
                    result.setText(null);
                } else {
                    Log.i("multiply", "else statement");
                    val1 = Double.parseDouble(first.getText().toString());
                    val2 = Double.parseDouble(second.getText().toString());
                    result.setText(String.valueOf(val1 * val2));
                    error.setText(null);
                }
            }
        });


        divide.setOnClickListener(new View.OnClickListener() {      // #/0 = infinity? or Error: Cannot divide by 0
            @Override
            public void onClick(View v) {
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                Log.i("divide", "inside divide");
                if (first.getText().toString().equals("") || second.getText().toString().equals("")) {
                    Log.i("divide", "if statement");
                    error.setText("ERROR: Insert values for both numbers.");
                    result.setText(null);
                } else if (second.getText().toString().equals("0")) {
                    Log.i("divide", "divide by 0");
                    error.setText("ERROR: Cannot divide by 0.");
                    result.setText(null);
                } else {
                    Log.i("divide", "else statement");
                    val1 = Double.parseDouble(first.getText().toString());
                    val2 = Double.parseDouble(second.getText().toString());
                    result.setText(String.valueOf(val1 / val2));
                    error.setText(null);
                }
            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("clear", "inside clear");
                result.setText(null);
                first.setText(null);
                second.setText(null);
                error.setText(null);
            }
        });
    }

    private void configure() {
        add = findViewById(R.id.add);           // BUTTONS
        subtract = findViewById(R.id.subtract);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        clear = findViewById(R.id.clear);
        back = findViewById(R.id.back);

        first = findViewById(R.id.first);       // EDIT TEXT
        second = findViewById(R.id.second);

        error = findViewById(R.id.error);       // TEXT VIEW
        result = findViewById(R.id.result);
    }
}