import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
        Car[] sorted = Arrays.copyOf(cars, cars.length); //cars 보존을 위해 배열 복사
        Arrays.sort(sorted,
            Comparator.comparingInt(car -> car.location)); //car.location을 기준으로 정렬용 배열 생성
        int maxlocation = sorted[cars.length - 1].location; //제일 앞으로 나간 car의 location 구하기

        //요구사항 에러 부분
        //1등 차가 여러개인 경우 -> winner 리스트에 넣고 출력
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.location == maxlocation) {
                winners.add(car);
            }
        }
        return winners;
    }
}
