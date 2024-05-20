package util;

public class Constants {

    public static final int START_LOCATION = 0;
    public static final int MAX_LENGTH_OF_RACING_CAR_NAME = 5;
    public static final int MIN_VALUE_OF_TRY_COUNT = 0;
    public static final int UPPER_BOUND_OF_RANDOM_NUMBER = 10;
    public static final int LOWER_BOUND_OF_MOVE = 4;

    public static final String NAMES_SEPARATOR = ",";
    public static final String WINNER_NAME_DELIMITER = ",";

    public static final String DEFAULT_ERROR_MESSAGE = "[ERROR]";
    public static final String NAMES_INPUT_GUIDE =
        String.format("경주할 자동차 이름을 입력하세요(이름은 쉼표(%s)를 기준으로 구분).", NAMES_SEPARATOR);
    public static final String TRY_COUNT_INPUT_GUIDE = "시도할 회수는 몇회인가요?";
    public static final String RESULT_PRINT_START_GUIDE = "\n실행 결과";

    public static final String FORMAT_OF_GAME_STATUS = "%s : %s";
    public static final String SYMBOL_OF_STATUS = "-";

    public static final String FORMAT_OF_WINNERS = "%s가 최종 우승했습니다.";
}
