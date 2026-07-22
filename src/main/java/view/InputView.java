package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in); // Scanner객체 만듬

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Arrays.stream(SCANNER.nextLine().split(",")) // 문자열로 읽고 쉼표 기준으로 분리
                .map(String::trim) // 앞뒤 공백 제거
                .toList(); // 리스트로 만들어 반환
    }

    public static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(SCANNER.nextLine()); // 입력값을 문자열로 받아 정수로 변환해 반환
    }
}