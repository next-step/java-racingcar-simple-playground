import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    //cars 배열 내의 객체들 움직이기
    public void moveCarList() {
        for (Car car : cars) {
            car.moveCar();
        }

        for (Car car : cars) {
            String bar = "-".repeat(car.location);
            System.out.println(car.name + ": " + bar);
        }

        System.out.print("\n");

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
        return cars.stream()
                .mapToInt(car -> car.location)
                .max()
                .getAsInt();
    }

    public List<Car> getCarsAtLocation(int location) {
        return cars.stream()
                .filter(car -> car.location == location)
                .toList();

    }

    //쉼표 마지막 처리 요구사항대로 수정 필요
    public void printWinner() {
        List<Car> winners = getWinner();
        String names = winners.stream()
                .map(car -> car.name)
                .collect(Collectors.joining(","));
        System.out.println(names + "가 최종 우승했습니다");
    }
}
