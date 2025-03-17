package CarGame2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        List<String> carNames = getCarNames();
        int rounds = getRounds();
        Race race = new Race(carNames, rounds);
        race.startRace();
    }

    private static List<String> getCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("자동차의 이름을 쉼표로 구분하여 입력하세요: ");
        String[] names = scanner.nextLine().split(",");
        List<String> carNames = new ArrayList<>();
        for (String name : names) {
            carNames.add(name.trim());
        }
        return carNames;
    }

    private static int getRounds() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("게임의 라운드 수를 입력하세요: ");
        return scanner.nextInt();
    }
}
