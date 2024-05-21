package hexlet.code.games;

import hexlet.code.Engine;

import hexlet.code.Utils;


public class Progression {
    private static final int PROGRESSION_LIMIT_UPPER  = 10;
    private static final int HOW_MANY_LIMIT_LOWER     = 5;
    private static final int HOW_MANY_LIMIT_UPPER     = 11;
    private static final int SKIP_LIMIT_LOWER         = 0;


    public static void run() {
        var questions = new String[Engine.ROUNDS_COUNT][];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            questions[i] = generateRound();
        }
        Engine.run(questions, "What number is missing in the progression?");
    }

    private static String[] generateRound() {
        var first_value            = Utils.generateRandomNumber();
        var progression_length     = Utils.generateRandomNumber(PROGRESSION_LIMIT_UPPER);
        var progression_step       = Utils.generateRandomNumber(HOW_MANY_LIMIT_LOWER, HOW_MANY_LIMIT_UPPER);
        var skipped_number         = Utils.generateRandomNumber(SKIP_LIMIT_LOWER, progression_step);
        String[] numberProgression = generateProgression(first_value, progression_length, progression_step);

        var correctAnswer             = numberProgression[skipped_number];
        numberProgression[skipped_number] = "..";
        var answer                    = String.join(" ", numberProgression);

        return new String[]{answer, correctAnswer};
    }

    private static String[] generateProgression(int number, int progression, int howManyNumbers) {
        String[] numberProgression = new String[howManyNumbers];
        var      nextNumber = number;
        numberProgression[0] = String.valueOf(number);

        for (int i = 1; i < howManyNumbers; i++) {
            nextNumber += progression;
            numberProgression[i] = String.valueOf(nextNumber);
        }

        return numberProgression;
    }
}
