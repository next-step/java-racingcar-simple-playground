package CarGame2;

import java.util.Scanner;

public class GameManager {
    public static void main(String[] args) {
        startGame();
    }
    private static void startGame(){
        int carCount = getCarCount();
        int rounds = getRounds();
        Race race = new Race(carCount, rounds);
        race.startRace();

    }
    private static int getCarCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("자동차의 개수를 입력하세요: ");
        return scanner.nextInt();
    }

    private static int getRounds() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("게임의 라운드 수를 입력하세요: ");
        return scanner.nextInt();
    }
}