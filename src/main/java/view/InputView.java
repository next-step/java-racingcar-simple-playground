package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCars() {
        return scanner.nextLine();
    }

    public static int inputTryCount() {
        return scanner.nextInt();
    }
}
