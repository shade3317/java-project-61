package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;


public class Calc {
    private static final int NUMBER_LIMIT_LOWER = 1;
    private static final int NUMBER_LIMIT_UPPER = 100;
    private static final int SYMBOL_LIMIT_LOWER = 1;
    private static final int SYMBOL_LIMIT_UPPER = 4;


    public static void run() {
        var questions = new String[Engine.ROUNDS_COUNT][];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            questions[i] = generateRound();
        }
        Engine.run(questions, "What is the result of the expression?");
    }

    private static String[] generateRound() {
        var number1       = new Random().nextInt(NUMBER_LIMIT_LOWER, NUMBER_LIMIT_UPPER);
        var number2       = new Random().nextInt(NUMBER_LIMIT_LOWER, NUMBER_LIMIT_UPPER);
        var symbol        = symbolGeneration();
        var answer        = number1 + " " + symbol + " " + number2;
        var correctAnswer = calculate(number1, number2, symbol);

        return new String[]{answer, String.valueOf(correctAnswer)};
    }

    private static char symbolGeneration() {
        var number = new Random().nextInt(SYMBOL_LIMIT_LOWER, SYMBOL_LIMIT_UPPER);

        return switch (number) {
            case 1 -> '+';
            case 2 -> '-';
            case 3 -> '*';
            default -> throw new RuntimeException("Unknown operation");
        };
    }

    private static int calculate(int number1, int number2, char symbol) {
        return switch (symbol) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            case '*' -> number1 * number2;
            default -> throw new RuntimeException("Unknown operation");
        };
    }
}
