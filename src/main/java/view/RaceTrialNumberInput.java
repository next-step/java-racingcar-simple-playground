package view;

import java.util.Scanner;

public class RaceTrialNumberInput {
    private static final String TRIAL_NUMBER_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public Integer getRaceTrialNumber() {
        System.out.println(TRIAL_NUMBER_INPUT_MESSAGE);
        return scanner.nextInt();
    }
}
