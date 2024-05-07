package hexlet.code;

import java.util.Random;


public class Utils {
    private static final int LIMIT_LOWER = 1;
    private static final int LIMIT_UPPER = 100;


    public static int generateRandomNumber(int limitLower, int limitUpper) {
        return new Random().nextInt(limitLower, limitUpper);
    }
    public static int generateRandomNumber(int limitUpper) {
        return generateRandomNumber(LIMIT_LOWER, limitUpper);
    }
    public static int generateRandomNumber() {
        return generateRandomNumber(LIMIT_LOWER, LIMIT_UPPER);
    }
}
