package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;


public class Prime {
    private static final int NUMBER_LIMIT_LOWER = 1;
    private static final int NUMBER_LIMIT_UPPER = 100;


    public static void run() {
        var questions = new String[Engine.ROUNDS_COUNT][];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            questions[i] = generateRound();
        }
        Engine.run(questions, "Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    private static String[] generateRound() {
        var number        = new Random().nextInt(NUMBER_LIMIT_LOWER, NUMBER_LIMIT_UPPER);
        var correctAnswer = isSimple(number) ? "yes" : "no";

        return new String[]{String.valueOf(number), correctAnswer};
    }

    private static boolean isSimple(int number) {
        if (number < 2) return false;

        for (int i = 2; i <= number / 2; i++) {
            if(number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
