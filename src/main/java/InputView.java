import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final RacingGame racingGame;
    private final Scanner scanner = new Scanner(System.in);
    private final List<Car> cars = new ArrayList<>();

    public InputView(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void inputCarNames() throws Exception {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputValue = scanner.nextLine();
        String[] carsName = inputValue.split(",");

        validateName(carsName);

        for (int i = 0; i < carsName.length; i++) {
            cars.add(new Car(carsName[i]));
        }
        racingGame.setCars(cars);
    }

    public void validateName(String[] carsName) throws Exception {
        for (String carName : carsName) {
            // 자동차 이름 검증 (5자 이하)
            validateInput(carName);
        }
    }

    public void validateInput(String carName) throws Exception {
        if (carName.length() > 5) {
            throw new Exception("자동차 이름은 5자 이하여야합니다.");
        }
    }

    public int inputRaceRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        int rounds = scanner.nextInt();
        System.out.println();
        return rounds;
    }
}
