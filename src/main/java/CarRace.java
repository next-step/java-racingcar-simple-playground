import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {

    static List<Car> cars;

    public CarRace(int n, String[] names) {
        cars = new ArrayList<>();
        for(int i=0;i<n;i++) cars.add(new Car(names[i]));
    }

    public static void main(String[] args) {

        int n = 3;
        int count;
        String[] carNames;
        CarRace race;

        Scanner scan = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String str = scan.nextLine();
        carNames = str.split(",");

        race = new CarRace(3, carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        count = scan.nextInt();

        // 레이스 시작
        System.out.println("실행 결과");
        race.raceStart(count);


        String winnersNameString = race.selectWinners().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnersNameString + "가 최종 우승했습니다.");

    }
    /*
    우승자를 찾는 메서드
    1. 최고 거리를 구한다.
    2. 해당 거리에 해당하는 차들을 반환한다.
     */
    public List<Car> selectWinners(){
        int max = 0;
        // 가장 멀리간 자동차의 길이 구하기
        for (Car car : cars) {
            max = Math.max(car.getDistance(), max);
        }
        int finalMax = max;
        return cars.stream().filter(car -> car.getDistance() == finalMax).toList();
    }

    /*
    레이스를 시작하는 메서드
     */
    public void raceStart(int count){
        for (int i = 0; i < count; i++) {
            raceOneLap();
            Car.printCarsInfo(cars);
        }
    }

    /*
    각 차마다 랜덤 숫자 여부에 따라 전진
     */
    private void raceOneLap() {
        for (Car car : cars) {
            car.moveOrStop(RandomValueGenerator.generate());
        }
    }
}
