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
import android.widget.CheckBox;

public class DecimalToBinary extends AppCompatActivity {

    private Button back;
    private Button convert;
    private Button clear;

    private EditText decimal;

    private TextView error;
    private TextView result;

    private CheckBox binCheck;
    private CheckBox hexCheck;
    private CheckBox octCheck;

    private boolean bChecked;
    private boolean hChecked;
    private boolean oChecked;

    int input;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decimal_to_binary);

        configure();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
// if binary, then make convert convert to binary. else if hex, then make convert change to hex. else, return select 1 or dont select 2


        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bChecked = ((CheckBox) binCheck).isChecked();
                hChecked = ((CheckBox) hexCheck).isChecked();
                oChecked = ((CheckBox) octCheck).isChecked();

                if ((bChecked && hChecked && oChecked) || (bChecked && hChecked && !oChecked) || (bChecked && !hChecked && oChecked) || (!bChecked && hChecked && oChecked)) {
                    Log.i("convert", "111111111");
                    result.setText(null);
                    error.setText("ERROR: Check only one box.");
                }
                else if ((bChecked && !hChecked && !oChecked)) {   // binary
                    Log.i("convert", "2222222222");
                    InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                    text = decimal.getText().toString();
                    Log.i("DecToBi", "inside convert");

                    if (!checkError()){
                        Log.i("DecToBi convert", "else statement");

                        input = Integer.parseInt(decimal.getText().toString());
                        Log.i("input = ", String.valueOf(input));

                        result.setText("Result: " + String.valueOf(decimalToOther(input, 2)));
                        error.setText(null);
                    }

                }
                else if ((!bChecked && hChecked && !oChecked)) {   // hex
                    Log.i("convert", "33333333333");
                    InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                    text = decimal.getText().toString();
                    Log.i("DecToHex", "inside convert");

                    if (!checkError()) {
                        Log.i("DecToHex convert", "else statement");

                        input = Integer.parseInt(decimal.getText().toString());
                        Log.i("input = ", String.valueOf(input));

                        result.setText("Result: " + String.valueOf(decimalToOther(input, 16)));
                        error.setText(null);
                    }
                }
                else if ((!bChecked && !hChecked && oChecked)) { // octal
                    Log.i("convert", "555555555");
                    InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                    text = decimal.getText().toString();
                    Log.i("DecToOct", "inside convert");

                    if (!checkError()) {
                        Log.i("DecToOct convert", "else statement");

                        input = Integer.parseInt(decimal.getText().toString());
                        Log.i("input = ", String.valueOf(input));

                        result.setText("Result: " + String.valueOf(decimalToOther(input, 8)));
                        error.setText(null);
                    }
                }
                else{
                    Log.i("else", "44444444444");
                    result.setText(null);
                    error.setText("ERROR: Check one of the boxes.");
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decimal.setText(null);
                result.setText(null);
                error.setText(null);
                binCheck.setChecked(false);
                hexCheck.setChecked(false);
                octCheck.setChecked(false);
            }
        });
    }

    private void configure() {
        back = findViewById(R.id.back);
        convert = findViewById(R.id.convert);
        clear = findViewById(R.id.clear);

        decimal = findViewById(R.id.decimal);

        error = findViewById(R.id.error);
        result = findViewById(R.id.result);

        binCheck = findViewById(R.id.binCheck);
        hexCheck = findViewById(R.id.hexCheck);
        octCheck = findViewById(R.id.octCheck);

    }

     // https://stackoverflow.com/questions/13465098/decimal-to-hexadecimal-converter-in-java
    
    public String decimalToOther(int num, int base) { // base can be anything under 16
        String digits = "0123456789abcdef";
        if (num <= 0)
            return "0";
        String ans = "";
        while (num > 0) {
            int digit = num % base;
            ans = digits.charAt(digit) + ans;
            num = num / base;
        }
        return ans;
    }

    public boolean checkError() {
        if (decimal.getText().toString().equals("")) {
            Log.i("DecToHex, solve", "if statement");
            error.setText("ERROR: Insert a value.");
            result.setText(null);
            return true;
        } else if (!text.matches("^[0-9_]+$")) {
            Log.i("DecToHex", "else if");
            error.setText("ERROR: Values may only contain positive whole numbers.");
            result.setText(null);
            return true;
        }
        return false;
    }
}
