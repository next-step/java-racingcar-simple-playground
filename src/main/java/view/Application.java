package view;

import domain.CarRace;
import java.util.Scanner;

public class Application {
    private final CarRace carrace = new CarRace();

    public void run() {
        String[] carNames = inputCarNames();
        int trialCount = inputTryCount();

        int[] carScores = new int[carNames.length];
        printGameResult(carScores, carNames, trialCount);

        printFinalWinner(carScores, carNames);
    }

    private String[] inputCarNames() {
        Scanner input = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = input.nextLine().split(",");
        carrace.validateCarNames(names);
        return names;
    }

    private int inputTryCount() {
        Scanner input = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        return input.nextInt();
    }

    private void printGameResult(int[] scores, String[] names, int count) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            carrace.playRound(scores);
            printStatus(scores, names);
        }
    }

    private void printFinalWinner(int[] scores, String[] names) {
        String winner = carrace.getWinners(scores, names);
        System.out.println(winner + "가 최종 우승했습니다.");
    }

    public void printStatus(int[] carscores, String[] carnames) {
        for (int i = 0; i < carscores.length; i++) {
            System.out.println(carnames[i] + " : " + carrace.getTrace(carscores[i]));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Application game = new Application();
        game.run();
    }
}
