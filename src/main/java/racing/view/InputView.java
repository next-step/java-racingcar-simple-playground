package racing.view;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.";
    private static final String INPUT_CAR_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String carName = scanner.nextLine();
        validateCarNameFormat(carName);

        return carName;
    }

    public static int inputTrialNumberCount() {
        System.out.println(INPUT_CAR_COUNT_MESSAGE);
        String input = scanner.nextLine();
        return parseTrialCount(input);
    }

    private static void validateCarNameFormat(String input){
        if(input.isBlank()){
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
        String noSpaceInput = input.replace(" ","");
        if(noSpaceInput.contains(",,")){
            throw new IllegalArgumentException("[ERROR] 쉼표가 연속으로 입력되었습니다.");
        }
        if(input.startsWith(",")||input.endsWith(",")){
            throw new IllegalArgumentException("[ERROR] 입력값의 시작이나 끝에 쉼표가 있습니다.");
        }

    }
    private static int parseTrialCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 정수 형의 숫자여야 합니다.");
        }
    }
}

