package core.basesyntax;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Calculator {
    private static final Map<Character, BinaryOperator<Double>> OPERATIONS = new HashMap<>();

    static {
        OPERATIONS.put('+', Double::sum);
        OPERATIONS.put('-', (a, b) -> a - b);
        OPERATIONS.put('*', (a, b) -> a * b);
        OPERATIONS.put('/', (a, b) -> a / b);
        OPERATIONS.put('^', Math::pow);
    }

    public static Map<Character, BinaryOperator<Double>> getOPERATIONS() {
        return OPERATIONS;
    }

    public static double calculate(double num1, double num2, char operation) {
        if (!OPERATIONS.containsKey(operation)) {
            throw new IllegalArgumentException("The operation" + operation + " isn't supported");
        }
        if (operation == '/' && num2 == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return OPERATIONS.get(operation).apply(num1, num2);
    }
}
