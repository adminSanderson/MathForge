package main.java.com.core.mathforge.operations;

import main.java.com.core.mathforge.UnaryOperation;

public class Factorial implements UnaryOperation {
    public int apply(int a) {
        int result = 1;
        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        return result;
    }
}