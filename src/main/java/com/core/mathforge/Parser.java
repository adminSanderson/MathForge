package main.java.com.core.mathforge;
/**
 * Парсер, который просто передаёт строку для вычисления.
 */
public class Parser {

    private final String expression;

    public Parser(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }
}
