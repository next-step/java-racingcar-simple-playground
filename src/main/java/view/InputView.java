package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
  private final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private final String INPUT_MAX_ATTEMPT_MESSAGE = "시도할 회수는 몇회인가요?";

  public List<String> inputNameList() {

    // 스캐너 선언
    Scanner scanner = new Scanner(System.in);

    // 자동차 이름 입력받기
    System.out.println(INPUT_NAME_MESSAGE);
    String str = scanner.nextLine();

    // nameList 반환 (공백제거 및 split)
    List<String> nameList = new ArrayList<>();
    nameList = Arrays.stream(str.replaceAll(" ",  "").split(",")).toList();

    return nameList;
  }

  public int inputAttempt() {

    // 스캐너 선언
    Scanner scanner = new Scanner(System.in);

    // 시도횟수 입력받기
    System.out.println(INPUT_MAX_ATTEMPT_MESSAGE);
    int attempt = scanner.nextInt();

    // 시도횟수 반환
    return attempt;

  }

}
