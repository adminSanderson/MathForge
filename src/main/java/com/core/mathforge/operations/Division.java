package main.java.com.core.mathforge.operations;

import main.java.com.core.mathforge.Operation;

public class Division implements Operation {
    public int apply(int a, int b) {
        if (b == 0) throw new ArithmeticException("Division by zero");
        return a / b;
    }
}