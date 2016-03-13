package com.aleks.calculator;

/**
 * Created by aleks on 12/03/16.
 */
public class CalculatorEngine {

    private static final String TAG = "MainActivity: ";

    private String currentNumber = "0";

    private String currentOperation = null;

    private double nr1 = 0;
    private String nr2 = null;

    public void setCurrentNumber (String number) {
        currentNumber = number;
    }

    public void addNumber (int number) {
        this.currentNumber = this.currentNumber + number;
    }

    public String getCurrentNumber() {
        return this.currentNumber;
    }

    //Numbri lisamine
    public void insert(int number){
        if (nr2 != null) {
            nr2 = nr2 + number;
        } else {
            nr2 = "" + number;
        }
        currentNumber = nr2;
    }

    //Erinevad operationid
    public void operation(String operation) {
        switch (operation) {
            case "+" :
                currentOperation = "+";
                if(nr2 != null) {
                    calculation();
                }
                break;
            case "-" :
                if(nr2 != null) {
                    calculation();
                }
                currentOperation = "-";
                break;
            case "/" :
                if(nr2 != null) {
                    calculation();
                }
                currentOperation = "/";
                break;
            case "*" :
                if(nr2 != null) {
                    calculation();
                }
                currentOperation = "*";
                break;
        }
        currentNumber = nr2;
    }

    //Arvutamine
    public void calculation() {
        if(nr2 != null) {
            switch (currentOperation) {
                case "+":
                    nr1 = nr1 + Double.parseDouble(nr2);
                    break;
                case "-":
                    nr1 = nr1 - Double.parseDouble(nr2);
                    break;
                case "/":
                    nr1 = nr1 / Double.parseDouble(nr2);
                    break;
                case "*":
                    nr1 = nr1 * Double.parseDouble(nr2);
                    break;
            }
        }
        nr2 = null;
        currentNumber = "" + nr1;
    }

    //Koma lisamine
    public void comma() {
        if(nr2.contains(".")) {

        } else {
            if(nr2 == null) {
                nr2 = "0.";
            } else {
                nr2 = nr2 + ".";
            }

        }
        currentNumber = nr2;
    }

    //Kustutamine / reset
    public void clear() {
        currentOperation = null;
        nr1 = 0;
        nr2 = null;
        currentNumber = "" + nr1;
    }
}
