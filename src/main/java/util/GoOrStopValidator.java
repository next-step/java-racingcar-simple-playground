package util;

public class GoOrStopValidator {

    private static final int GO_OR_STOP_STANDARD = 4;

    public static boolean validateGoOrStop(final int randomValue) {
        return randomValue >= GO_OR_STOP_STANDARD;
    }
}
