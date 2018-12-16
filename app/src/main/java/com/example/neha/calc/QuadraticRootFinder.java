package com.example.neha.calc;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import android.widget.EditText;
import android.view.inputmethod.InputMethodManager;

public class QuadraticRootFinder extends AppCompatActivity {

    private Button back;
    private Button solve;
    private Button clear;

    private EditText xsquared;
    private EditText xfirst;
    private EditText constant;

    private TextView x1;
    private TextView x2;
    private TextView x1result;
    private TextView x2result;
    private TextView error;

    double a;
    double b;
    double c;
    double discriminant;
    double x1ans;
    double x2ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratic_root_finder);

        configure();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                Log.i("QuadraticRootFinder", "inside solve");
                if (xsquared.getText().toString().equals("") || xfirst.getText().toString().equals("") || constant.getText().toString().equals("")) {
                    Log.i("Quadratic, solve", "if statement");
                    error.setText("ERROR: Insert values for all numbers.");
                    x1result.setText(null);
                    x2result.setText(null);
                } else {
                    Log.i("Quadratic, solve", "else statement");

                    a = Double.parseDouble(xsquared.getText().toString());
                    b = Double.parseDouble(xfirst.getText().toString());
                    c = Double.parseDouble(constant.getText().toString());

                    discriminant = b * b - 4 * a * c;
                    x1ans = (-b + Math.sqrt(discriminant)) / 2 * a;
                    x2ans = (-b - Math.sqrt(discriminant)) / 2 * a;

                    // only one root
                    if (discriminant == 0) {
                        x1result.setText(String.valueOf(x1ans));
                        x2result.setText("There's only one root.");
                    }
                    // both roots are imaginary
                    else if (discriminant < 0) {
                        x1result.setText("Imaginary");
                        x2result.setText("Imaginary");
                    }
                    // both roots are real
                    else {
                        x1result.setText(String.valueOf(x1ans));
                        x2result.setText(String.valueOf(x2ans));
                    }

                    error.setText(null);
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                xsquared.setText(null);
                xfirst.setText(null);
                constant.setText(null);
                x1result.setText(null);
                x2result.setText(null);
                error.setText(null);
            }
        });
    }

    private void configure() {
        // Buttons
        back = findViewById(R.id.back);
        solve = findViewById(R.id.solve);
        clear = findViewById(R.id.clear);

        // EditText
        xsquared = findViewById(R.id.xsquared);
        xfirst = findViewById(R.id.xfirst);
        constant = findViewById(R.id.constant);

        // Text View
        x1 = findViewById(R.id.x1);
        x1.setText("x1 = ");

        x2 = findViewById(R.id.x2);
        x2.setText("x2 = ");

        x1result = findViewById(R.id.x1result);
        x2result = findViewById(R.id.x2result);

        error = findViewById(R.id.error);

    }
}