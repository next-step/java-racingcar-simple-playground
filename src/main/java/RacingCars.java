import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private Car[] cars;

    public RacingCars(Car[] cars) {
        this.cars = cars;
    }

    //cars 배열 내의 객체들 움직이기
    public void moveCarList() {
        for (Car car : cars) {
            car.moveCar();
        }
    }

    //주어진 횟수만큼 차 움직이기
    public void playRound(int roundcnt) {
        for (int i = 0; i < roundcnt; i++) {
            moveCarList();
        }
    }

    //우승 차 구하기
    public List<Car> getWinner() {
        int maxLocation = getMaxLocation();
        return getCarsAtLocation(maxLocation);
    }

    public int getMaxLocation() {
        return Arrays.stream(cars) //배열의 스트림 형태로 변환
            .mapToInt(car -> car.location) //각 car 객체에서 .location
            //값을 꺼내고 -> 그 값들만 흐르는 새로운 IntStream 생성
            .max()
            .getAsInt();
    }

    public List<Car> getCarsAtLocation(int location) {
        return Arrays.stream(cars)
            .filter(car -> car.location == location)
            .collect(Collectors.toList());
    }
}
