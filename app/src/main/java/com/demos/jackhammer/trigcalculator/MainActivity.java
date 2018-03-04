package com.demos.jackhammer.trigcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.os.Handler;
import android.os.Message;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    /*Handler h = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };*/

   // final EditText sine = (EditText) findViewById(R.id.result);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

    public void goToLawActivity(View v) {
        Intent i = new Intent(this, LawofSinesCosines.class);
        startActivity(i);
    }

    public void goToCoterminal(View v) {
        Intent i = new Intent(this, Coterminal.class);
        startActivity(i);
    }

    public void sinButtonClick(View v) {
        new Thread(new Runnable() {
            public void run() {
                double deg, rad;

                EditText input;
                input = (EditText) findViewById(R.id.angle);
                final EditText sine = (EditText) findViewById(R.id.result);
                final RadioButton dMode = (RadioButton) findViewById(R.id.degreeMode);

                deg = Double.parseDouble(input.getText().toString());
                rad = Math.toRadians(deg);
                final double resInRad = Math.sin(deg);
                final double resInDeg = Math.sin(rad);

                sine.post(new Runnable() {
                    public void run() {
                        if (dMode.isChecked())
                            sine.setText(String.valueOf(resInDeg));
                        else
                            sine.setText(String.valueOf(resInRad));
                    }
                });
            }
        }).start();
    }

    public void cosButtonClick(View v) {
        new Thread(new Runnable() {
            public void run() {
                double deg, rad;

                EditText input;
                input = (EditText) findViewById(R.id.angle);
                final EditText cosine = (EditText) findViewById(R.id.result);
                final RadioButton dMode = (RadioButton) findViewById(R.id.degreeMode);

                deg = Double.parseDouble(input.getText().toString());
                rad = Math.toRadians(deg);
                final double resInRad = Math.cos(deg);
                final double resInDeg = Math.cos(rad);

                cosine.post(new Runnable() {
                    public void run() {
                        if (dMode.isChecked())
                            cosine.setText(String.valueOf(resInDeg));
                        else
                            cosine.setText(String.valueOf(resInRad));
                    }
                });
            }
        }).start();
    }

    public void tanButtonClick(View v) {
        new Thread(new Runnable() {
            public void run() {
                double deg, rad;

                EditText input;
                input = (EditText) findViewById(R.id.angle);
                final EditText tangent = (EditText) findViewById(R.id.result);
                final RadioButton dMode = (RadioButton) findViewById(R.id.degreeMode);

                deg = Double.parseDouble(input.getText().toString());
                rad = Math.toRadians(deg);
                final double resInRad = Math.tan(deg);
                final double resInDeg = Math.tan(rad);

                tangent.post(new Runnable() {
                    public void run() {
                        if (dMode.isChecked())
                            tangent.setText(String.valueOf(resInDeg));
                        else
                            tangent.setText(String.valueOf(resInRad));
                    }
                });
            }
        }).start();
    }

    public void aSinButtonClick(View v) {
        new Thread(new Runnable() {
            public void run() {
                double sine;

                EditText input;
                input = (EditText) findViewById(R.id.angle);
                final RadioButton dMode = (RadioButton) findViewById(R.id.degreeMode);
                final EditText arcSin = (EditText) findViewById(R.id.result);

                sine = Double.parseDouble(input.getText().toString());
                final double res = Math.asin(sine);
                final double valInDegrees = Math.toDegrees(res);

                arcSin.post(new Runnable() {
                    public void run() {
                        if (dMode.isChecked()) {
                            arcSin.setText(String.valueOf(valInDegrees));
                        }
                        else {
                            arcSin.setText(String.valueOf(res));
                        }
                    }
                });
            }
        }).start();
    }

    public void aCosButtonClick(View v) {
        new Thread(new Runnable() {
            public void run() {
                double cosine;

                EditText input;
                input = (EditText) findViewById(R.id.angle);
                final RadioButton dMode = (RadioButton) findViewById(R.id.degreeMode);
                final EditText arcCos = (EditText) findViewById(R.id.result);

                cosine = Double.parseDouble(input.getText().toString());
                final double res = Math.acos(cosine);
                final double valInDegrees = Math.toDegrees(res);

                arcCos.post(new Runnable() {
                    public void run() {
                        if (dMode.isChecked()) {
                            arcCos.setText(String.valueOf(valInDegrees));
                        }
                        else {
                            arcCos.setText(String.valueOf(res));
                        }
                    }
                });
            }
        }).start();
    }

    public void aTanButtonClick(View v) {
        new Thread(new Runnable() {
            public void run() {
                double tangent;

                EditText input;
                input = (EditText) findViewById(R.id.angle);
                final RadioButton dMode = (RadioButton) findViewById(R.id.degreeMode);
                final EditText arcTan = (EditText) findViewById(R.id.result);

                tangent = Double.parseDouble(input.getText().toString());
                final double res = Math.atan(tangent);
                final double valInDegrees = Math.toDegrees(res);

                arcTan.post(new Runnable() {
                    public void run() {
                        if (dMode.isChecked()) {
                            arcTan.setText(String.valueOf(valInDegrees));
                        }
                        else {
                            arcTan.setText(String.valueOf(res));
                        }
                    }
                });
            }
        }).start();
    }

    public void secButtonClick(View v) {
        new Thread(new Runnable() {
            public void run() {
                double deg, rad;

                EditText input;
                input = (EditText) findViewById(R.id.angle);
                final EditText secant = (EditText) findViewById(R.id.result);
                final RadioButton dMode = (RadioButton) findViewById(R.id.degreeMode);

                deg = Double.parseDouble(input.getText().toString());
                rad = Math.toRadians(deg);
                final double resInRad = 1 / Math.cos(deg);
                final double resInDeg = 1 / Math.cos(rad);

                secant.post(new Runnable() {
                    public void run() {
                        if (dMode.isChecked())
                            secant.setText(String.valueOf(resInDeg));
                        else
                            secant.setText(String.valueOf(resInRad));
                    }
                });
            }
        }).start();
    }

    public void cscButtonClick(View v) {
        new Thread(new Runnable() {
            public void run() {
                double deg, rad;

                EditText input;
                input = (EditText) findViewById(R.id.angle);
                final EditText cosecant = (EditText) findViewById(R.id.result);
                final RadioButton dMode = (RadioButton) findViewById(R.id.degreeMode);

                deg = Double.parseDouble(input.getText().toString());
                rad = Math.toRadians(deg);
                final double resInRad = 1 / Math.sin(deg);
                final double resInDeg = 1 / Math.sin(rad);

                cosecant.post(new Runnable() {
                    public void run() {
                        if (dMode.isChecked())
                            cosecant.setText(String.valueOf(resInDeg));
                        else
                            cosecant.setText(String.valueOf(resInRad));
                    }
                });
            }
        }).start();
    }

    public void cotButtonClick(View v) {
        new Thread(new Runnable() {
            public void run() {
                double deg, rad;

                EditText input;
                input = (EditText) findViewById(R.id.angle);
                final EditText cotangent = (EditText) findViewById(R.id.result);
                final RadioButton dMode = (RadioButton) findViewById(R.id.degreeMode);

                deg = Double.parseDouble(input.getText().toString());
                rad = Math.toRadians(deg);
                final double resInRad = 1 / Math.tan(deg);
                final double resInDeg = 1 / Math.tan(rad);

                cotangent.post(new Runnable() {
                    public void run() {
                        if (dMode.isChecked())
                            cotangent.setText(String.valueOf(resInDeg));
                        else
                            cotangent.setText(String.valueOf(resInRad));
                    }
                });
            }
        }).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
