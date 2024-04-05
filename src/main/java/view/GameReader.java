package view;

import java.util.Scanner;

public class GameReader {

    private static final String NAME_QUERY =
            "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String COUNT_QUERY = "시도할 회수는 몇회인가요?";

    public static String getNames() {
        System.out.println(NAME_QUERY);
        return readString();
    }

    public static int getCount() {
        System.out.println(COUNT_QUERY);
        return readInt();
    }

    private static String readString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
