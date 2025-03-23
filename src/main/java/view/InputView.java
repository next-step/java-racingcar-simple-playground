package view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class InputView {

    private static final int MAX_LENGTH = 5;
    private static final int MAX_CAR_NUMBER = 10;
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getCarNames() {
        List<String> names = Arrays.asList(scanner.nextLine().split(","));
        checkLength(names);
        checkBlank(names);
        checkDuplicates(names);
        checkCarNumber(names);
        return names;
    }

    public static int getRoundNumber() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static void checkLength(List<String> names) {
        if (hasTooLongName(names)) {
            throw new IllegalArgumentException("[Error] 이름은 " + MAX_LENGTH + "자를 초과할 수 없습니다.");
        }
    }

    public static void checkBlank(List<String> names) {
        if (hasBlank(names)) {
            throw new IllegalArgumentException("[Error] 이름은 공백으로 이루어질 수 없습니다.");
        }
    }

    public static void checkCarNumber(List<String> names) {
        if (names.size() > MAX_CAR_NUMBER) {
            throw new IllegalArgumentException("[Error] 차의 개수는 10대를 초과할 수 없습니다.");
        }
    }

    public static void checkDuplicates(List<String> names) {
        if (hasDuplicates(names)) {
            throw new IllegalArgumentException("[Error] 차의 이름은 중복될 수 없습니다.");
        }
    }

    private static boolean hasTooLongName(List<String> names) {
        return names.stream()
                .anyMatch(name -> name.length() > MAX_LENGTH);
    }

    private static boolean hasBlank(List<String> names) {
        return names.stream()
                .anyMatch(name -> name.trim().isEmpty());
    }

    private static boolean hasDuplicates(List<String> names)  {
        Set<String> nameSet = new HashSet<>();
        return names.stream()
                .anyMatch(name -> !nameSet.add(name));
    }
}
