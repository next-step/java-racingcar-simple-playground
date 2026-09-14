import java.util.ArrayList;

public class CarRace {
    private int carCount;
    private int roundCount;
    private int maxPosition;
    ArrayList<Car> cars;
    ArrayList<Car> winners;

    // 생성자: n대 정보 추가, 리스트 생성
    public CarRace(ArrayList<Car> cars, int roundCount) {
        carCount = cars.size();
        this.roundCount = roundCount;
        maxPosition = 0;
        this.cars = cars;
        winners = new ArrayList<>();
    }

    // 우승자들을 찾아서 반환
    public ArrayList<Car> getWinners() {
        for (int i = 0; i < carCount; i++) {
            findMaxPosition(cars.get(i));
        }
        for (Car car : cars) {
            findWinners(car);
        }
        return winners;
    }

    // 가장 많이 움직인 자동차들을 찾기
    private void findWinners(Car car) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
    }

    private void race() {
        for (int i = 0; i < roundCount; i++) {
            moveCars();
        }
    }

    // 최대 position 찾기
    private void findMaxPosition(Car car) {
        if (car.getPosition() > maxPosition) {
            maxPosition = car.getPosition();
        }
    }

    private static final int MAX_RANDOM_VALUE = 9;

    // 경기를 1회 진행
    private void moveCars() {
        RandomNumGenerator randomNumgenerator =
                new RandomNumGenerator(MAX_RANDOM_VALUE);
        for (int i = 0; i < carCount; i++) {
            cars.get(i).moveCar(randomNumgenerator);
            findMaxPosition(cars.get(i));
        }
    }
}
