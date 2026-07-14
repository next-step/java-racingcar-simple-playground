package view;

import java.util.Scanner;

public class RaceTrialNumberInput {
    private static final String TRIAL_NUMBER_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    private final Scanner scanner;

    public RaceTrialNumberInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getRaceTrialNumber() {
        System.out.println(TRIAL_NUMBER_INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
