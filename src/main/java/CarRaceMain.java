import NumberGenerator.RandomNumberGenerator;
import java.util.Scanner;

public class CarRaceMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final Race race;

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = sc.nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        int count = sc.nextInt();

        race = new Race(carNames, count);
        race.start(new RandomNumberGenerator());

    }
}
