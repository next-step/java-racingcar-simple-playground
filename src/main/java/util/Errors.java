package util;

public class Errors {

    public static final String INPUT_IS_NOT_NATURAL_NUMBER_ERROR = "시도 횟수로는 음수가 입력될 수 없습니다.";
    public static final String INPUT_IS_NOT_INTEGER = "시도 횟수로는 정수가 입력되어야 합니다.";
    private static final String FORMAT_OF_CAR_NAME_LENGTH_ERROR = "자동차 이름(%s)은 %d자 이하여야 합니다.";


    public static String getLengthOfCarNameError(String carName) {
        return String.format(FORMAT_OF_CAR_NAME_LENGTH_ERROR, carName, Constants.MAX_LENGTH_OF_RACING_CAR_NAME);
    }
}
