import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayGame {
    private final Scanner scanner = new Scanner(System.in);

    public List<String> readNames() {
        List<String> carNames = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String value = scanner.nextLine();
        String[] splitNames = value.split(",");
        for (String name : splitNames) {
            carNames.add(nameError(name.trim()));
        }

        return carNames;
    }

    public String nameError(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다");
        }
        return name;
    }

    public List<RacingCar> createCars(List<String> carNames) {
        List<RacingCar> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new RacingCar(name));
        }
        return cars;
    }

    public int tryCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        int number = scanner.nextInt();

        return number;
    }

    public void result(List<RacingCar> cars, int tryCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            startMove(cars);
        }
    }

    private void startMove(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            car.move(car.randomNum());
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PlayGame game = new PlayGame();
        List<String> carNames = game.readNames();
        List<RacingCar> cars = game.createCars(carNames);
        int tryCount = game.tryCount();

        game.result(cars, tryCount);

        WinRacingCar winRacingCar = new WinRacingCar();
        List<RacingCar> winners = new ArrayList<>();
        winners = winRacingCar.whoWin(cars);

        List<String> winnerNames = new ArrayList<>();
        for (RacingCar winner : winners) {
            winnerNames.add(winner.getName());
        }
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }
}
