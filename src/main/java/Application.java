import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();
        
        System.out.println("시도할 회수는 몇회인가요?");
        int round = scanner.nextInt();
        System.out.println();

        List<Car> cars = new ArrayList<>();

        for (String name : carNames.split(",")) {
            cars.add(new Car(name));
        }

        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            for (Car car : cars) {
                System.out.print(car.getName() + ":");
                for (int j = 0; j < car.getPosition(); j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

        RacingGame racingGame = new RacingGame(cars);

        List<Car> winners = new ArrayList<>();

        winners = racingGame.findWinners();

        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
        }
        System.out.print("가 최종 우승했습니다.");

        scanner.close();
    }
}