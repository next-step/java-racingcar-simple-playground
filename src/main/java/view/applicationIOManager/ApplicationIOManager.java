package view.applicationIOManager;

import java.util.Scanner;


public class ApplicationIOManager {
    Scanner scanner = new Scanner(System.in);

    private static String[] parseParticipant(String names) {

        return names.split("\\s*,\\s*");
    }

    public UserInput getUserInput() {
        UserInput userInput = new UserInput();

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.nextLine();
        String[] participants = parseParticipant(names);
        if (participants.length == 0) {
            throw new IllegalArgumentException("자동차 이름이 잘못 입력되었습니다.(입력값이 없습니다.)");
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int attempt = scanner.nextInt();
        System.out.println();

        userInput.setParticipants(participants);
        userInput.setAttempt(attempt);

        return userInput;
    }

    public void printResult(String[] winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
