package car;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String nameInput = sc.nextLine();
        List<String> names = List.of(nameInput.split(","));

        System.out.println("시도할 회수는 몇회인가요?");
        int count = inputCount(sc);

        RacingCar game = new RacingCar(names, count);
        game.start();
    }

    private static int inputCount(Scanner sc) {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return Integer.parseInt(sc.nextLine()); // nextInt()보다 nextLine() 후 파싱이 버퍼 관리에 유리합니다.
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}