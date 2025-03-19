package view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static String[] getCarNames() {
        return scanner.nextLine().split(",");
    }

    public static int getRoundNumber() {
        return Integer.parseInt(scanner.nextLine());
    }

}
