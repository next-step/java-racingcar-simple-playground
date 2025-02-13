import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class CarRace {
    private final List<Car> cars = new ArrayList<>();

    // 자동차 말의 개수 설정 및 자동차 번호 할당
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

    // 우승자 차량 번호 확인
    public int getWinnerCarNumber() {
        return cars.stream() //스트림으로 변환
                .max(Comparator.comparingInt(Car::getPosition)) //임의 객체의 인스턴스 메소드 참조 이용 position 값 추출, position 값이 가장 높은 객체 선택
                .orElseThrow(NoSuchElementException::new) // 객체가 존재하면 Optional 벗겨서 반환, 없으면 예외 던짐
                .getCarNumber(); // 해당 객체의 차량 번호 반환
    }
}
