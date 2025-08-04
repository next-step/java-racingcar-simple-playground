import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Application {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        List<String> carNames = inputCarNames(scanner);
        int rounds = inputRounds(scanner);

        RacingGame game = createGame(carNames);
        playGame(game, rounds);

        scanner.close();
    }

    private List<String> inputCarNames(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        return parseCarNames(input);
    }

    private List<String> parseCarNames(String input) {
        String[] names = input.split(CAR_NAME_DELIMITER);
        List<String> carNames = new ArrayList<>();

        for (String name : names) {
            String trimmedName = name.trim();
            validateCarName(trimmedName);
            carNames.add(trimmedName);
        }

        return carNames;
    }

    private void validateCarName(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private int inputRounds(Scanner scanner) {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    private RacingGame createGame(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return new RacingGame(cars);
    }

    private void playGame(RacingGame game, int rounds) {
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < rounds; i++) {
            game.playOneRound();
            printGameStatus(game);
            System.out.println();
        }

        printWinners(game);
    }

    private void printGameStatus(RacingGame game) {
        for (Car car : game.getCars()) {
            System.out.println(car.getName() + " : " + createPositionDisplay(car.getPosition()));
        }
    }

    private String createPositionDisplay(int position) {
        StringBuilder display = new StringBuilder();
        for (int i = 0; i < position; i++) {
            display.append("-");
        }
        return display.toString();
    }

    private void printWinners(RacingGame game) {
        List<String> winners = game.getWinners();
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
