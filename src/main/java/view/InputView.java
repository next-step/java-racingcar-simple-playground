import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public List<String> inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputValue = scanner.nextLine();
        String[] carNamesArray = inputValue.split(",");
        List<String> carNames = new ArrayList<>();
        for (String carName : carNamesArray) {
            carNames.add(carName.trim());
        }
        return carNames;
    }

    public int inputRaceRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        int rounds = promptForValidNumber();
        System.out.println();
        return rounds;
    }

    public int promptForValidNumber() {
        while (!scanner.hasNextInt()) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            scanner.next();
        }
        return scanner.nextInt();
    }

}
