package hexlet.code.games;

import hexlet.code.Engine;

import hexlet.code.Utils;


public class GCD {
    public static void run() {
        var questions = new String[Engine.ROUNDS_COUNT][];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            questions[i] = generateRound();
        }
        Engine.run(questions, "Find the greatest common divisor of given numbers.");
    }

    private static String[] generateRound() {
        var number1       = Utils.generateRandomNumber();
        var number2       = Utils.generateRandomNumber();
        var answer        = number1 + " " + number2;
        var correctAnswer = calculateGCD(number1, number2);

        return new String[]{answer, String.valueOf(correctAnswer)};
    }

    private static int calculateGCD(int inNumber1, int inNumber2) {
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
