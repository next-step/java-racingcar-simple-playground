import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    // 문자열로 입력받은 자동차 이름들을 쉼표 기준으로 분리하고 공백 제거
    public String[] readCarNames() {
        String line = scanner.nextLine();

        String[] inputs = line.split(",");
        String[] names = new String[inputs.length];

        for (int i = 0; i < inputs.length; i++) {
            names[i] = inputs[i].trim();
        }

        return names;
    }

    // 입력받은 경주 횟수를 숫자로 변환
    public int readRaceCount() {
        return Integer.parseInt(scanner.nextLine().trim());
    }
}
