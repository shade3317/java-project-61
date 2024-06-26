package hexlet.code.games;

import hexlet.code.Engine;

import hexlet.code.Utils;


public class Calc {
    private static final int    SYMBOL_LIMIT_LOWER = 0;
    private static final char[] SYMBOLS            = {'+', '-', '*'};



    public static void run() {
        var questions = new String[Engine.ROUNDS_COUNT][];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            questions[i] = generateRound();
        }
        Engine.run(questions, "What is the result of the expression?");
    }

    private static String[] generateRound() {
        var number1       = Utils.generateRandomNumber();
        var number2       = Utils.generateRandomNumber();
        var numberSymbol  = Utils.generateRandomNumber(SYMBOL_LIMIT_LOWER, SYMBOLS.length);
        var answer        = number1 + " " + SYMBOLS[numberSymbol] + " " + number2;
        var correctAnswer = calculateExpression(number1, number2, numberSymbol);

        return new String[]{answer, String.valueOf(correctAnswer)};
    }

    private static int calculateExpression(int number1, int number2, int numberSymbol) {
        return switch (SYMBOLS[numberSymbol]) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            case '*' -> number1 * number2;
            default -> throw new RuntimeException("Unknown operation");
        };
    }
}
