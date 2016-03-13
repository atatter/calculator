package com.aleks.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity: ";
    private static final String STATE_CALCULATION = "userCalculation";

    private CalculatorEngine calculator = new CalculatorEngine();

    private TextView textViewAnswer;
    private Button btnZero;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnComma;
    private Button btnClear;
    private Button btnEqual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(BuildConfig.DEBUG) {
            Log.e(TAG, "onCreate called");
        }
        if(savedInstanceState != null) {
            if(BuildConfig.DEBUG) {
                Log.e(TAG, "onSavedInstanceState onCreate called");
            }
            calculator.setCurrentNumber(savedInstanceState.getString(STATE_CALCULATION));
        }

        //Ühendan nupud äpiga
        textViewAnswer = (TextView) findViewById(R.id.nrfield);
        textViewAnswer.setText("");
        btnZero = (Button) findViewById(R.id.btn16);
        btnOne = (Button) findViewById(R.id.btn11);
        btnTwo = (Button) findViewById(R.id.btn12);
        btnThree = (Button) findViewById(R.id.btn13);
        btnFour = (Button) findViewById(R.id.btn07);
        btnFive = (Button) findViewById(R.id.btn08);
        btnSix = (Button) findViewById(R.id.btn09);
        btnSeven = (Button) findViewById(R.id.btn03);
        btnEight = (Button) findViewById(R.id.btn04);
        btnNine = (Button) findViewById(R.id.btn05);
        btnPlus = (Button) findViewById(R.id.btn10);
        btnMinus = (Button) findViewById(R.id.btn14);
        btnMultiply = (Button) findViewById(R.id.btn06);
        btnDivide = (Button) findViewById(R.id.btn02);
        btnComma = (Button) findViewById(R.id.btn15);
        btnEqual = (Button) findViewById(R.id.btn17);
        btnClear = (Button) findViewById(R.id.btn01);

        //Nupp "1" OnClick
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.insert(1);
                textViewAnswer.setText(calculator.getCurrentNumber());
            }
        });
        //Nupp "2" OnClick
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.insert(2);
                textViewAnswer.setText(calculator.getCurrentNumber());
            }
        });
        //Nupp "3" OnClick
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.insert(3);
                textViewAnswer.setText(calculator.getCurrentNumber());
            }
        });
        //Nupp "4" OnClick
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.insert(4);
                textViewAnswer.setText(calculator.getCurrentNumber());
            }
        });
        //Nupp "5" OnClick
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.insert(5);
                textViewAnswer.setText(calculator.getCurrentNumber());
            }
        });
        //Nupp "6" OnClick
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.insert(6);
                textViewAnswer.setText(calculator.getCurrentNumber());
            }
        });
        //Nupp "7" OnClick
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.insert(7);
                textViewAnswer.setText(calculator.getCurrentNumber());
            }
        });
        //Nupp "8" OnClick
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.insert(8);
                textViewAnswer.setText(calculator.getCurrentNumber());
            }
        });
        //Nupp "9" OnClick
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.insert(9);
                textViewAnswer.setText(calculator.getCurrentNumber());
            }
        });
        //Nupp "0" OnClick
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.insert(0);
                textViewAnswer.setText(calculator.getCurrentNumber());
            }
        });
        //Nupp "+" OnClick
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.operation("+");
                textViewAnswer.setText(calculator.getCurrentNumber());
            }
        });
        //Nupp "-" OnClick
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.operation("-");
                textViewAnswer.setText(calculator.getCurrentNumber());
            }
        });
        //Nupp "*" OnClick
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.operation("*");
                textViewAnswer.setText(calculator.getCurrentNumber());
            }
        });
        //Nupp "/" OnClick
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.operation("/");
                textViewAnswer.setText(calculator.getCurrentNumber());
            }
        });
        //Nupp "=" OnClick
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.calculation();
                textViewAnswer.setText(calculator.getCurrentNumber());
            }
        });
        //Nupp "Comma" OnClick
        btnComma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.comma();
                textViewAnswer.setText(calculator.getCurrentNumber());
            }
        });
        //Nupp "Clear" OnClick
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.clear();
                textViewAnswer.setText(calculator.getCurrentNumber());
            }
        });
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
        //savedIntanceState.putInt(STATE_CALCULATION, calculator.getCurrentNumber());

        super.onSaveInstanceState(savedIntanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(BuildConfig.DEBUG) {
            Log.e(TAG, "onStart called");
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(BuildConfig.DEBUG) {
            Log.e(TAG, "onRestart called");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(BuildConfig.DEBUG) {
            Log.e(TAG, "onResume called");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(BuildConfig.DEBUG) {
            Log.e(TAG, "onPause called");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(BuildConfig.DEBUG) {
            Log.e(TAG, "onStop called");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(BuildConfig.DEBUG) {
            Log.e(TAG, "onDestroy called");
        }
    }
}
