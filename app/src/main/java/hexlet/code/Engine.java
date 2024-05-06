package hexlet.code;

import java.util.Scanner;



public class Engine {
    public static final int ROUNDS_COUNT = 3;


    public static void run(String[][] rounds, String rules) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(rules);

        for (String[] round : rounds) {
            System.out.println("Question: " + round[0]);
            System.out.println("Your answer: ");
            String answer = scanner.next();
            if(answer.equals(round[1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was " +
                                   "'" + round[1] + "'" + ".");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}

