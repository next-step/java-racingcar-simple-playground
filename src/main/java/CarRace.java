import java.util.ArrayList;

public class CarRace {
    private final int carCount;
    private final int roundCount;
    private int maxPosition;
    private ArrayList<Car> cars;
    private ArrayList<Car> winners;
    private NumberGenerator numberGenerator;

    // 생성자: n대 정보 추가, 리스트 생성
    public CarRace(ArrayList<Car> cars, int roundCount, NumberGenerator numberGenerator) {
        validateCars(cars);
        validateRoundCount(roundCount);

        carCount = cars.size();
        this.roundCount = roundCount;
        maxPosition = 0;
        this.cars = cars;
        winners = new ArrayList<>();
        this.numberGenerator = numberGenerator;
    }

    private void validateCars(ArrayList<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차 입력 안 됨");
        }
    }

    private void validateRoundCount(int roundCount) {
        if (roundCount <= 0) {
            throw new IllegalArgumentException("roundCount가 0 이하임");
        }
    }

    // 경기를 roundCount만큼 진행
    public void race() {
        for (int i = 0; i < roundCount; i++) {
            moveCars(numberGenerator, 0, carCount);
        }
    }

    // 경기를 1회 진행
    private void moveCars(NumberGenerator randomNumber, int start, int end) {
        for (int i = start; i < end; i++) {
            cars.get(i).moveCar(randomNumber);
        }
    }

    // 우승자들을 찾아서 반환
    public ArrayList<Car> getWinners() {
        findMaxPosition();
        findWinners();
        return winners;
    }

    // 최대 position 찾기
    private void findMaxPosition() {
        int max;
        for (Car car : cars) {
            max = car.getLargerPosition(maxPosition);
            maxPosition = max;
        }
    }

    // 가장 많이 움직인 자동차들을 찾기
    private void findWinners() {
        for (Car car : cars) {
            addWinners(car);
        }
    }

    private void addWinners(Car car) {
        if (car.isSamePosition(maxPosition)) {
            winners.add(car);
        }
    }
}
