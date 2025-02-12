import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarRace {
    private final List<Car> cars = new ArrayList<>();
    int maxPosition = 0;

    // 자동차 말의 개수 설정 및 자동차 객체 생성 및 번호 할당
    public void setCarCount(int num) {
        for(int i = 0; i <= num; i++) {
            cars.add(new Car(i));
        }
    }

    // 모든 차가 한번씩 움직임
    public void moveCars() {
        for (Car car : cars) {
            car.tryMove();
        }
    }

    // count 만큼 모든 차가 한번씩 움직임
    public void doRace(int count) {
        for (int i = 0; i < count; i++) {
            moveCars();
        }
    }

    // 우승자 차의 전진 횟수 확인
    public void setMaxPosition() {
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

    }

    // 우승자 선별
    public int getWinnerCarNumber() {
        return cars.stream()        // 스트림으로 변환
                .max(Comparator.comparingInt(Car::getPosition)) //Car::getPosition 값이 가장 큰 객체를 스트림에서 찾기, Optional<Car> 반환
                .get()              // Optional<Car> 에서 Car 객체를 가져옴
                .getCarNumber();    // 가져온 Car 객체에서 CarNumber 추출

    }
}
