import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class RacingCar {

    private Car[] cars;
    private Random random;

    //사용자 입장
    public RacingCar(String[] names) {
        this(names, new Random()); //car의 이름 배열, 랜덤 객체 넘겨주기
    }

    //테스트 용이성을 위해 오버라이딩 (random 고정을 위해서)
    public RacingCar(String[] names, Random random) {
        this.cars = new Car[names.length]; //사용자가 준 car 이름 배열 크기만큼 객체 배열 생성
        this.random = random; //테스트 -> 숫자 고정, 사용자 -> 랜덤 객체 전달

        //cars라는 객체 배열에 사용자가 준 이름과 랜덤 객체 넘겨주기
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i], random);
        }
    }

    //cars 배열 내의 객체들 움직이기
    public void moveCar() {
        for (Car car : cars) {
            car.moveCar();
        }
    }

    //주어진 횟수만큼 차 움직이기
    public void playRound(int roundcnt) {
        for (int i = 0; i < roundcnt; i++) {
            moveCar();
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
