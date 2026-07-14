package view;

import java.util.Scanner;

public class CarNameInput {
    private static final String CAR_NAME_INPUT_MESSAGE = "자동차 이름을 입력하세요.(여러 대 일 경우 ','(콤마)로 구분하니 ,을 입력해주세요)";

    private final Scanner scanner = new Scanner(System.in);

    public String getCarName() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
