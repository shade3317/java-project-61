package hexlet.code.games;

import hexlet.code.Engine;

import hexlet.code.Utils;


public class Prime {
    public static void run() {
        var questions = new String[Engine.ROUNDS_COUNT][];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            questions[i] = generateRound();
        }
        Engine.run(questions, "Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    private static String[] generateRound() {
        var number        = Utils.generateRandomNumber();
        var correctAnswer = isPrime(number) ? "yes" : "no";

        return new String[]{String.valueOf(number), correctAnswer};
    }

    private static boolean isPrime(int number) {
        if (number < 2) return false;

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
