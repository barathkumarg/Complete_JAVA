package app.calculator;

import app.calculator.util.Addhelper;

public class Calculator {

    public int add(int i, int j){
        Addhelper addhelper = new Addhelper();
        return addhelper.addhelper(i,j);
    }
}
