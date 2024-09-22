package util;

import java.util.Scanner;

public class InputFromUser {

    static Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        return scanner.nextLine();
    }

    public static int inputExecutionsCount() {
        return scanner.nextInt();
    }
}
