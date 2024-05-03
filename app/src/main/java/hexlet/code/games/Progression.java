package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;


public class Progression {
    private static final int NUMBER_LIMIT_LOWER    = 1;
    private static final int NUMBER_LIMIT_UPPER    = 100;
    private static final int NUMBER_P_LIMIT_LOWER  = 1;
    private static final int NUMBER_P_LIMIT_UPPER  = 10;
    private static final int NUMBER_HM_LIMIT_LOWER = 5;
    private static final int NUMBER_HM_LIMIT_UPPER = 11;
    private static final int NUMBER_S_LIMIT_LOWER  = 0;


    public static void run() {
        var questions = new String[Engine.ROUNDS_COUNT][];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            questions[i] = generateRound();
        }
        Engine.run(questions, "What number is missing in the progression?");
    }

    private static String[] generateRound() {
        var number            = new Random().nextInt(NUMBER_LIMIT_LOWER,    NUMBER_LIMIT_UPPER);
        var numberProgression = new Random().nextInt(NUMBER_P_LIMIT_LOWER,  NUMBER_P_LIMIT_UPPER);
        var howManyNumbers    = new Random().nextInt(NUMBER_HM_LIMIT_LOWER, NUMBER_HM_LIMIT_UPPER);
        var numberSkip        = new Random().nextInt(NUMBER_S_LIMIT_LOWER,  howManyNumbers);
        var answer            = String.valueOf(number);
        var correctAnswer     = number;

        for (int i = 0; i <= howManyNumbers; i++) {
            number += numberProgression;
            if (i == numberSkip) {
                answer = answer + " " + "..";
                correctAnswer = number;
            } else {
                answer = answer + " " + number;
            }
        }

        return new String[]{answer, String.valueOf(correctAnswer)};
    }
}
