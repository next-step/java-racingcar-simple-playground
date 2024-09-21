import java.util.*;

public class CarGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = scanner.nextLine().split(",");

        System.out.println("시도할 횟수는 몇회인가요?");
        int n = scanner.nextInt();

        // 자동차 객체 생성
        List<Car> cars = createCar(carNames);

        // 주어진 횟수 동안 실행
        moveCar(cars, n);

        // 최대 전진 횟수 구하기
        int maxDistance = findMaxDistance(cars);

        // 최대 전진 횟수를 가지는 자동차 이름 구하기
        List<String> winners = findWinner(cars, maxDistance);

        // 최종 우승 자동차 출력
        printWinner(winners);

        // scanner 해제
        scanner.close();
    }

    // 자동차 객체 생성
    private static List<Car> createCar(String[] carNames){
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return cars;
    }

    // 주어진 횟수 동안 실행
    private static void moveCar(List<Car> cars, int n){
        for (int i = 0; i < n; i++) {
            for (Car car : cars) {
                car.move();
            }
            System.out.println();
        }
    }

    // 최대 전진 횟수 구하기
    private static int findMaxDistance(List<Car> cars) {
        int maxDistance = 0, distance;

        for (Car car : cars) {
            distance = car.getDistance();
            if (distance > maxDistance)
                maxDistance = distance;
        }

        return maxDistance;
    }

    // 최대 전진 횟수를 가지는 자동차 이름 구하기
    private static List<String> findWinner(List<Car> cars, int maxDistance) {
        List<String> winners = new ArrayList<>();;
        int distance;

        for (Car car : cars) {
            distance = car.getDistance();
            if (distance == maxDistance)
                winners.add(car.getName());
        }

        return winners;
    }

    // 최종 우승 자동차 출력
    private static void printWinner(List<String> winners){
        for (int i = 0; i < winners.size(); i++){
            if (i == winners.size() - 1){
                System.out.print(winners.get(i));
                continue;
            }
            System.out.print(winners.get(i) + ", ");
        }
        System.out.println("가 최종 우승했습니다.");
    }
}