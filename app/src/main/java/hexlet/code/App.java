package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;


public class App {
    public static final int GREET            = 1;
    public static final int GAME_EVEN        = 2;
    public static final int GAME_CALC        = 3;
    public static final int GAME_GCD         = 4;
    public static final int GAME_PROGRESSION = 5;
    public static final int GAME_PRIME       = 6;
    public static final int EXIT             = 0;


    public static void main(String[] args) {
        Scanner game = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");

        System.out.println("Your choice: ");
        int numberGame = game.nextInt();
        switch (numberGame) {
            case GREET:
                Cli.greet();
                break;
            case GAME_EVEN:
                Even.run();
                break;
            case GAME_CALC:
                Calc.run();
                break;
            case GAME_GCD:
                GCD.run();
                break;
            case GAME_PROGRESSION:
                Progression.run();
                break;
            case GAME_PRIME:
                Prime.run();
                break;
            case EXIT:
                break;
            default: throw new RuntimeException("Unknown operation");
        }
    }
}
