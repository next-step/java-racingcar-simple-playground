import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String value = scanner.nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        int number = scanner.nextInt();
        String[] carName = value.split(",");
        for (int i = 0; i < carName.length; i++) {
            carName[i] = carName[i].trim();
        }
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carName.length; i++) {
            cars.add(new Car(carName[i]));
        }
        NumberGenerator numberGenerator = new MakeRandomNum();
        Play race = new Play(cars, numberGenerator);
        race.totalPlay(number);
        System.out.println("실행결과");
        for (int i = 0; i < cars.size(); i++) {
            System.out.printf("%s : ", carName[i]);
            for (int j = 0; j < cars.get(i).position; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        race.getWinners(cars);

        for (int i = 0; i < race.winner.size(); i++) {
            System.out.printf("%s ", race.winner.get(i).name);
        }
        System.out.println("가 최종 우승했습니다.");
    }
}
