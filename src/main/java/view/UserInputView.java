package view;

import java.util.Scanner;

public class UserInputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String readStringInput() {
        return scanner.nextLine();
    }

    public static int readIntegerInput() {
        return scanner.nextInt();
    }
}
