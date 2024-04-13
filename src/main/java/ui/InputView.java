package ui;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private final Reader reader;

    public InputView(final Reader reader) {
        this.reader = reader;
    }

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        return Arrays.stream(readLine().split(","))
                .map(String::trim)
                .toList();
    }

    private String readLine() {
        return reader.readLine();
    }

    public int inputRaceTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        return reader.readNumber();
    }
}
