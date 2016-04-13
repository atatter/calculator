package com.aleks.calculator;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String STATE_NR1 = "nr1";
    private static final String STATE_NR2 = "nr2";
    private static final String STATE_RES = "res";
    private static final String STATE_OP = "op";

    private Numberz calculator = new Numberz();

    private TextView textViewAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null) {

            calculator.setNr1(savedInstanceState.getDouble(STATE_NR1));
            calculator.setNr2(savedInstanceState.getString(STATE_NR2));
            calculator.setCurrentOperator(savedInstanceState.getString(STATE_OP));
            calculator.setRes(savedInstanceState.getDouble(STATE_RES));

        }

        //Ühendan nupud äpiga
        textViewAnswer = (TextView) findViewById(R.id.nrfield);
        textViewAnswer.setText("");
        drawCurrentCalculator();
    }


    public void drawCurrentCalculator() {
        textViewAnswer.setText(calculator.toString());
    }

    @Override
    public void onSaveInstanceState(Bundle savedIntanceState) {

        savedIntanceState.putDouble(STATE_NR1, calculator.getNr1());
        savedIntanceState.putString(STATE_NR2, calculator.getNr2());
        savedIntanceState.putDouble(STATE_RES, calculator.getRes());
        savedIntanceState.putString(STATE_OP, calculator.getCurrentOperator());

        super.onSaveInstanceState(savedIntanceState);
    }

    public void nrOnclick(View view) {
        Button btn = (Button) view;
        //See on vajutatud nupu tekst
        int nr = Integer.parseInt(btn.getText().toString());
        calculator.insertNr(nr);
        textViewAnswer.setText(calculator.toString());
    }

    public void opOnclick(View view) {
        Button btn = (Button) view;
        //See on vajutatud nupu tekst
        String op = btn.getText().toString();



            if (calculator.getCurrentOperator() == null && calculator.getNr2() == null) {
                calculator.setCurrentOperator(op);
            } else if (calculator.getNr2() != null && calculator.getCurrentOperator() == null) {
                calculator.setNr1(Double.parseDouble(calculator.getNr2()));
                calculator.setNr2(null);
                calculator.setCurrentOperator(op);
            } else if (calculator.getCurrentOperator() != null && calculator.getNr2() == null) {
                calculator.setCurrentOperator(op);
            } else {
                if (op == "=") {
                    sendBroadcast();
                    calculator.setNr1(calculator.getRes());
                    calculator.setNr2(null);
                    calculator.setCurrentOperator(null);
                    return;
                } else {
                    sendBroadcast();
                    calculator.setNr1(calculator.getRes());
                    calculator.setNr2(null);
                    calculator.setCurrentOperator(op);
                    return;
                }
            }


        textViewAnswer.setText(calculator.toString());
    }

    public void resetOnclick(View view) {
        calculator.clear();
        textViewAnswer.setText(calculator.toString());
    }

    public void commaOnclick(View view) {
        calculator.comma();
        textViewAnswer.setText(calculator.toString());
    }

    public void sendBroadcast() {
        Intent intent = new Intent();
        intent.setAction("com.aleks.CALCULATE");
        sendBroadcast(intent);
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        intent.putExtra("val1", calculator.getNr1());
        intent.putExtra("val2", Double.parseDouble(calculator.getNr2()));
        intent.putExtra("op", calculator.getCurrentOperator());
        sendOrderedBroadcast(intent, null, new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                double res = Double.parseDouble(getResultData());
                calculator.setRes(res);
                calculator.setNr1(res);
                textViewAnswer.setText(getResultData());
            }
        }, null, Activity.RESULT_OK, null, null);
    }
}
