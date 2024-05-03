package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;


public class GCD {
    private static final int NUMBER_LIMIT_LOWER = 1;
    private static final int NUMBER_LIMIT_UPPER = 100;


    public static void run() {
        var questions = new String[Engine.ROUNDS_COUNT][];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            questions[i] = generateRound();
        }
        Engine.run(questions, "Find the greatest common divisor of given numbers.");
    }

    private static String[] generateRound() {
        var number1       = new Random().nextInt(NUMBER_LIMIT_LOWER, NUMBER_LIMIT_UPPER);
        var number2       = new Random().nextInt(NUMBER_LIMIT_LOWER, NUMBER_LIMIT_UPPER);
        var answer        = number1 + " " + number2;
        var correctAnswer = calculate(number1, number2);

        return new String[]{answer, String.valueOf(correctAnswer)};
    }

    private static int calculate(int inNumber1, int inNumber2) {
        var number1 = inNumber1;
        var number2 = inNumber2;

        while (number2 != 0) {
            int tmpNumber = number1 % number2;
            number1 = number2;
            number2 = tmpNumber;
        }

        return number1;
    }
}
