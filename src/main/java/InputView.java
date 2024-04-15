import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public String[] inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String carNameString = scanner.nextLine();
        return carNameString.split(",");
    }

    public int inputAttempt(){
        System.out.println("시도할 횟수는 몇회인가요?");
        return scanner.nextInt();
    }
}
