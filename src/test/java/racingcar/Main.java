package racingcar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        raceGame race = new raceGame();

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner sc = new Scanner(System.in);
        String nameString = sc.nextLine();
        race.setCars(race.splitName(nameString));

        System.out.println("시도할 횟수는 몇 회인가요?");
        int numberOfGames = sc.nextInt();

        System.out.println("\n실행 결과");
        for (int i = 0; i < numberOfGames; i++) {
            race.doGame();
        }

        race.printWinner();
    }
}
