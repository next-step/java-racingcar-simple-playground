package view;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    /*
     * 이름 입력받기
     * */
    // 리펙터링 : InputView는 입력만 담당해야 하므로 nameArr을 저장하지 않고 반환하도록 수정
    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String names = sc.nextLine();
        return names.split(",");
    }

    /*
     * 이동 횟수 입력받기
     * */
    // 리펙터링: InputView로 이동, moveCount를 리턴
    public static int inputMoveCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return sc.nextInt();
    }
}
