import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String value = scanner.nextLine();
        Stream<String> stream = Arrays.stream(value.split(","));
        stream.forEach(name -> {
            game.addCars(name);
        });

        System.out.println("시도할 회수는 몇회인가요?");
        int number = scanner.nextInt();
        game.setRounds(number);

        System.out.println("실행 결과");
        game.play();
    }
}
