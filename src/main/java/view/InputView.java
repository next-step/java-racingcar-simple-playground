package view;

import java.util.Scanner;

public class InputView implements AutoCloseable {
    private static final String DEFAULT_NAME_DELIMITER = ",";
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String[] getCarNames() {
        String inputNames = readLine("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] inputSplitNames = splitCarNames(inputNames);

        return inputSplitNames;
    }

    public int getGameCount() {
        int inputGameCount = readInt("시도할 회수는 몇회인가요?");
        scanner.nextLine();
        validateInputCount(inputGameCount);

        return inputGameCount;
    }

    private String[] splitCarNames(String names) {
        return names.split(DEFAULT_NAME_DELIMITER);
    }

    private void validateInputCount(int inputCount) {
        if (isIllegalInputCount(inputCount)) {
            throw new IllegalArgumentException("inputCount can't be less than 1");
        }
    }

    private boolean isIllegalInputCount(int count) {
        return count <= 0;
    }

    private String readLine(String prompt) {
        System.out.println(prompt);

        return scanner.nextLine();
    }

    public int readInt(String prompt) {
        System.out.println(prompt);

        return scanner.nextInt();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
