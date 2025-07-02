package main.java.com.core.mathforge;

import main.java.com.core.mathforge.operations.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Основной класс для вычисления простых арифметических выражений.
 * Поддерживает бинарные операции (+, -, *, /) и унарную операцию (! — факториал).
 */
public class Evaluator {

    // Хранилище бинарных операций, например: +, -, *, /
    private final Map<Character, Operation> binaryOperations = new HashMap<>();

    // Хранилище унарных операций, например: !
    private final Map<Character, UnaryOperation> unaryOperations = new HashMap<>();

    public Evaluator() {
        // Регистрируем бинарные операции
        binaryOperations.put('+', new Addition());
        binaryOperations.put('-', new Subtraction());
        binaryOperations.put('*', new Multiplication());
        binaryOperations.put('/', new Division());

        // Регистрируем унарную операцию факториала
        unaryOperations.put('!', new Factorial());
    }

    /**
     * Вычисляет выражение, состоящее из целых чисел, бинарных операций и факториала (!).
     * Пример: "5!+2" => 122
     */
    public int evaluate(String expression) {
        int currentNumber = 0;         // Текущее число, которое мы собираем из цифр
        int totalResult = 0;           // Накопленный результат
        char currentOperator = '+';    // Последняя бинарная операция

        for (int index = 0; index <= expression.length(); index++) {
            // Получаем символ выражения или '+' в конце для принудительной обработки
            char currentChar = index < expression.length() ? expression.charAt(index) : '+';
            
            // Если это цифра — продолжаем накапливать число
            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }
            
            // Если встретили факториал (!), применяем унарную операцию к текущему числу
            else if (currentChar == '!') {
                UnaryOperation factorial = unaryOperations.get('!');
                currentNumber = factorial.apply(currentNumber);
            }
            
            // Если текущий оператор — бинарный (+, -, *, /), применяем его
            else if (binaryOperations.containsKey(currentOperator)) {
                Operation operation = binaryOperations.get(currentOperator);
                totalResult = operation.apply(totalResult, currentNumber);
                currentOperator = currentChar; // Запоминаем новую операцию
                currentNumber = 0; // Сбрасываем число после применения
            }

            // Если встретили допустимую бинарную операцию — просто запоминаем её
            else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/' || index == expression.length()) {
                currentOperator = currentChar;
            }
        }

        return totalResult;
    }

    public static void main(String[] args) {
        Evaluator evaluator = new Evaluator();
        String expression = "!10+2"; // 120 + 2 = 122
        int result = evaluator.evaluate(expression);
        System.out.println(expression + " = " + result);
    }
}
