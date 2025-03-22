package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getCarNames() {
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public static int getRoundNumber() {
        return Integer.parseInt(scanner.nextLine());
    }

}
