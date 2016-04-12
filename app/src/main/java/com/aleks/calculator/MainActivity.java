package com.aleks.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity: ";
    private static final String STATE_CALCULATION = "userCalculation";
    private static final String STATE_NR2 = "nr2";
    private static final String STATE_NR = "nr1";

    private CalculatorEngine calculator = new CalculatorEngine();

    private TextView textViewAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(BuildConfig.DEBUG) {
            Log.e(TAG, "onCreate called");
        }
        if(savedInstanceState != null) {
            if (BuildConfig.DEBUG) {
                Log.e(TAG, "onSavedInstanceState onCreate called");
            }
            calculator.setCurrentNumber(savedInstanceState.getString(STATE_CALCULATION));
            calculator.setNr1(savedInstanceState.getDouble(STATE_NR));
            calculator.setNr2(savedInstanceState.getString(STATE_NR2));

        }

        //Ühendan nupud äpiga
        textViewAnswer = (TextView) findViewById(R.id.nrfield);
        textViewAnswer.setText("");
        drawCurrentCalculator();
    }


    public void drawCurrentCalculator() {
        textViewAnswer.setText("" + calculator.getCurrentNumber());
    }

    @Override
    public void onSaveInstanceState(Bundle savedIntanceState) {
        if(BuildConfig.DEBUG) {
            Log.e(TAG, "onSaveInstanceState called");
        }
        savedIntanceState.putString(STATE_CALCULATION, calculator.getCurrentNumber());
        savedIntanceState.putString(STATE_NR2, calculator.getNr2());
        savedIntanceState.putDouble(STATE_NR, calculator.getNr1());

        super.onSaveInstanceState(savedIntanceState);
    }

    public void nrOnclick(View view) {
        Button btn = (Button) view;
        //See on vajutatud nupu tekst
        int nr = Integer.parseInt(btn.getText().toString());
        calculator.insert(nr);
        textViewAnswer.setText(calculator.getCurrentNumber());
    }

    public void opOnclick(View view) {
        Button btn = (Button) view;
        //See on vajutatud nupu tekst
        String op = btn.getText().toString();
        calculator.operation(op);
        textViewAnswer.setText(calculator.getCurrentNumber());
    }

    public void resetOnclick(View view) {
        calculator.clear();
        textViewAnswer.setText(calculator.getCurrentNumber());
    }

    public void commaOnclick(View view) {
        calculator.comma();
        textViewAnswer.setText(calculator.getCurrentNumber());
    }

    public void equalOnclick(View view) {
        calculator.calculation();
        textViewAnswer.setText(calculator.getCurrentNumber());
    }
}
