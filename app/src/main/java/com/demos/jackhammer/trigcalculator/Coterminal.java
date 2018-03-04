package com.demos.jackhammer.trigcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class Coterminal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coterminal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void calcPosAngleClick(View v) {
        new Thread(new Runnable() {
            public void run() {
                double input;

                EditText angInput = (EditText) findViewById(R.id.angInput);
                final EditText angOutput = (EditText) findViewById(R.id.angOutput);

                input = Double.parseDouble(angInput.getText().toString());
                final double output = input + 360;

                angOutput.post(new Runnable() {
                    public void run() {
                        angOutput.setText(String.valueOf(output));
                    }
                });
            }
        }).start();
    }

    public void calcNegAngleClick(View v) {
        new Thread(new Runnable() {
            public void run() {
                double input;

                EditText angInput = (EditText) findViewById(R.id.angInput);
                final EditText angOutput = (EditText) findViewById(R.id.angOutput);

                input = Double.parseDouble(angInput.getText().toString());
                final double output = input - 360;

                angOutput.post(new Runnable() {
                    public void run() {
                        angOutput.setText(String.valueOf(output));
                    }
                });
            }
        }).start();
    }

    public void resetButtonClick(View v) {
        new Thread(new Runnable() {
            public void run() {
                final EditText angInput = (EditText) findViewById(R.id.angInput);
                final EditText angOutput = (EditText) findViewById(R.id.angOutput);

                angInput.post(new Runnable() {
                    public void run() {
                        angInput.setText("");
                    }
                });

                angOutput.post(new Runnable() {
                    @Override
                    public void run() {
                        angOutput.setText("");
                    }
                });
            }
        }).start();
    }

}
