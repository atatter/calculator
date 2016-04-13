package com.aleks.calculator;

/**
 * Created by aleks on 13/04/16.
 */
public class Numberz {
    private double nr1 = 0;
    private String nr2 = null;
    private double res = 0;
    private String currentOperator = null;

    public String currentCalculation;

    //NR1 get/set
    public double getNr1() {
        return nr1;
    }
    public void setNr1(double nr1) {
        this.nr1 = nr1;
    }

    //NR2 get/set
    public String getNr2() {
        return nr2;
    }
    public void setNr2(String nr2) {
        this.nr2 = nr2;
    }

    //RES get/set
    public double getRes() {
        return res;
    }
    public void setRes(double res) {
        this.res = res;
    }

    //CURRENTOPERATOR get/set
    public String getCurrentOperator() {
        return currentOperator;
    }
    public void setCurrentOperator(String currentOperator) {
        this.currentOperator = currentOperator;
    }

    public String toString() {
        if(nr2 != null && currentOperator == null) {
            return nr2;
        } else if(currentOperator != null && nr2 == null){
            return "" + nr1 + " " + currentOperator;
        } else if(currentOperator == null && nr2 == null) {
            return "";
        } else {
            return "" + nr1 + " " + currentOperator + " " + nr2;
        }
        //return getNr1() + " " + getCurrentOperator() + " " + getNr2();
    }

    //Insert number to nr2
    public void insertNr(int number) {
        switch(number) {
            case 0:
                if(nr2 == "0") {

                } else if (nr2 == null){
                    nr2 = "0";
                } else {
                    nr2 = nr2 + 0;
                }
                break;
            default:
                if (nr2 != null) {
                    nr2 = nr2 + number;
                } else {
                    nr2 = "" + number;
                }
                break;
        }
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
        currentOperator = null;
        nr1 = 0;
        nr2 = null;
    }
}
