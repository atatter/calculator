package com.aleks.calculator;

/**
 * Created by aleks on 12/03/16.
 */
public class CalculatorEngine {

    private static final String TAG = "MainActivity: ";

    private String currentNumber = "0";

    private String currentOperation = "+";

    private double nr1 = 0;
    private String nr2 = null;

    public void setCurrentNumber(String number) {
        currentNumber = number;
    }

    public void addNumber(int number) {
        this.currentNumber = this.currentNumber + number;
    }

    public String getCurrentNumber() {
        return this.currentNumber;
    }

    public String getNr2() {
        return this.nr2;
    }

    public void setNr2(String number){
        this.nr2 = number;
    }

    public double getNr1() {
        return this.nr1;
    }

    public void setNr1(Double number) {
        this.nr1 = number;
    }

    //Numbri lisamine
    public void insert(int number) {
        switch(number) {
            case 0:
                if(nr2.equals("0")) {

                } else {

                }
                break;
            default:
                if (nr2 != null) {
                    nr2 = nr2 + number;
                } else {
                    nr2 = "" + number;
                }
                currentNumber = nr2;
                break;
        }

    }

    //Erinevad operationid
    public void operation(String operation) {
        switch (operation) {
            case "+":
                if (nr2 != null) {
                    calculation();
                }
                currentOperation = "+";
                break;
            case "-":
                if (nr2 != null) {
                    calculation();
                }
                currentOperation = "-";
                break;
            case "/":
                if (nr2 != null) {
                    calculation();
                }
                currentOperation = "/";
                break;
            case "*":
                if (nr2 != null) {
                    calculation();
                }
                currentOperation = "*";
                break;
        }
        currentNumber = nr2;
    }

    //Arvutamine
    public void calculation() {
        if (nr2 != null) {
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
                default:
                    nr1 = nr1 + Double.parseDouble(nr2);
                    break;
            }
        }
        nr2 = null;
        currentNumber = "" + nr1;
    }

    //Koma lisamine
    public void comma() {

        if (nr2 != null) {
            if (nr2.contains(".")) {

            } else {
                nr2 = nr2 + ".";

            }
        } else {
            nr2 = "0.";
        }
    }

    //Kustutamine / reset
    public void clear() {
        currentOperation = "+";
        nr1 = 0;
        nr2 = null;
        currentNumber = "" + nr1;
    }
}
