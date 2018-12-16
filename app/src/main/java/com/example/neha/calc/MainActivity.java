package com.example.neha.calc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button fourFunct;
    private Button quad;
    private Button btd;
    private Button dtb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configure();

        fourFunct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FourFunctionCalculator.class));
            }
        });

        quad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, QuadraticRootFinder.class));
            }
        });

        btd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BinaryToDecimal.class));
            }
        });

        dtb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DecimalToBinary.class));
            }
        });
    }

    private void configure() {
        fourFunct = findViewById(R.id.fourFunct);
        quad = findViewById(R.id.quad);
        btd = findViewById(R.id.btd);
        dtb = findViewById(R.id.dtb);
    }
}
