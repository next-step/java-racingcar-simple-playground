import java.util.*;
import java.util.stream.Collectors;

public class CarRace {
    private final List<Car> cars = new ArrayList<>();
    List<String> carNames;
    int raceAttemptCount;
    List<String> winnerCarNames;

    public void receiveCarNamesInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String value = scanner.nextLine();
        if(value.isEmpty()) {
            throw new IllegalArgumentException("경주할 자동차의 이름을 반드시 입력해주세요.");
        }
        carNames = Arrays.asList(value.split(","));

        if(carNames.stream().anyMatch(cn -> cn.length()>5)) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하로 작성해주세요.");
        }

    }

    public void recieveCarRaceAttemptCountInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("시도할 회수는 몇회인가요?");
        raceAttemptCount = scanner.nextInt();
    }

    public void makeCarObject(int sizeOfList) {
        for(int i = 0; i < sizeOfList; i++) {
            cars.add(new Car(i, carNames.get(i)));
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.tryMove();
        }
    }

    public void doRace(int count) {
        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            moveCars();
            printRaceResult();
        }
    }

    public void printRaceResult() {
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void setWinnerCarNames() {
        int maxPosition = cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow(NoSuchElementException::new)
                .getPosition();

        winnerCarNames = cars.stream()
                .filter(c -> c.getPosition() == maxPosition)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public void printWinnerCarNames() {
        System.out.print(String.join(", ", winnerCarNames));
        System.out.println("가 최종 우승했습니다.");
    }

}
