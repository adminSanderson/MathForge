package main.java.com.core.mathforge;

public class Main {
    public static void main(String[] args) {
        String input = "3-(-4)";
        Parser parser = new Parser(input);

        Evaluator evaluator = new Evaluator();
        double result = evaluator.evaluate(parser.getExpression());

        System.out.println("Результат: " + result);
    }
}