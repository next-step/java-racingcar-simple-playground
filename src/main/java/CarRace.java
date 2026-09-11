import java.util.ArrayList;

public class CarRace {
    private int carCount;
    private int roundCount;
    private int maxPosition;
    ArrayList<Car> cars;
    ArrayList<Car> winners;

    // 생성자: n대 정보 추가, 리스트 생성
    public CarRace(ArrayList<Car> cars, int carCount, int roundCount) {
        this.carCount = carCount;
        this.roundCount = roundCount;
        maxPosition = 0;
        this.cars = cars;
        winners = new ArrayList<>();
    }

    // 경주 진행 메서드
    // 반복문으로 moveCar 실행
    // 누가 우승했는지 구하기

    public ArrayList<Car> getWinners() {
        race();
        for (Car car : cars) {
            findWinners(car);
        }
        return winners;
    }

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

    private void findMaxPosition(Car car) {
        if (car.getPosition() > maxPosition) {
            maxPosition = car.getPosition();
        }
    }

    private void moveCars() {
        for (int i = 0; i < carCount; i++) {
            int randomNumber = cars.get(i).makeRandomNum();
            cars.get(i).moveCar(randomNumber);
            findMaxPosition(cars.get(i));
        }
    }
}
