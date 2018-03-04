package com.demos.jackhammer.trigcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class LawofSinesCosines extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawof_sines_cosines);
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

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.degreeMode:
                if (checked)

                    break;
            case R.id.radianMode:
                if (checked)

                    break;
        }
    }

    //EditText sideA = (EditText) findViewById(R.id.sideA);

    public double computeAngleA(double a, double b, double c) {
        return Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c));
    }

    public double computeAngleB(double a, double b, double c) {
        return Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c));
    }

    public double computeAngleC(double a, double b, double c) {
        return Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b));
    }

    public boolean isEmpty(EditText text) {
        return text.getText().toString().trim().length() == 0;
    }

    public void calculateClick(View v) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                double a, b, c;
                final RadioButton dMode = (RadioButton) findViewById(R.id.degreeMode);
                final EditText sideA, sideB, sideC, angleA, angleB, angleC;

                sideA = (EditText) findViewById(R.id.sideA);
                sideB = (EditText) findViewById(R.id.sideB);
                sideC = (EditText) findViewById(R.id.sideC);
                angleA = (EditText) findViewById(R.id.angleA);
                angleB = (EditText) findViewById(R.id.angleB);
                angleC = (EditText) findViewById(R.id.angleC);

                a = Double.parseDouble(sideA.getText().toString());
                b = Double.parseDouble(sideB.getText().toString());
                c = Double.parseDouble(sideC.getText().toString());
                //A = Double.parseDouble(angleA.getText().toString());
                //B = Double.parseDouble(angleB.getText().toString());
                //C = Double.parseDouble(angleC.getText().toString());

                if ((!isEmpty(sideA)) && (!isEmpty(sideB)) && (!isEmpty(sideC))) {
                    final double AinDegrees = Math.toDegrees(computeAngleA(a, b, c));
                    final double BinDegrees = Math.toDegrees(computeAngleB(a, b, c));
                    final double CinDegrees = Math.toDegrees(computeAngleC(a, b, c));

                    final double A = computeAngleA(a, b, c);
                    final double B = computeAngleB(a, b, c);
                    final double C = computeAngleC(a, b, c);

                    angleA.post(new Runnable() {
                        @Override
                        public void run() {
                            if (dMode.isChecked())
                                angleA.setText(String.valueOf(AinDegrees));
                            else
                                angleA.setText(String.valueOf(A));
                        }
                    });

                    angleB.post(new Runnable() {
                        @Override
                        public void run() {
                            if (dMode.isChecked())
                                angleB.setText(String.valueOf(BinDegrees));
                            else
                                angleB.setText(String.valueOf(B));
                        }
                    });

                    angleC.post(new Runnable() {
                        @Override
                        public void run() {
                            if (dMode.isChecked())
                                angleC.setText(String.valueOf(CinDegrees));
                            else
                                angleC.setText(String.valueOf(C));
                        }
                    });
                }
            }
        }).start();
    }
}
