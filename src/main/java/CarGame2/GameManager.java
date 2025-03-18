package CarGame2;

public class GameManager {

    public static void main(String[] args) {
        try {
            startGame();
        } catch (Exception e) {
            System.out.println("시스템 오류가 발생했습니다. 다시 시도해주세요.");
            e.printStackTrace();
        }
    }

    private static void startGame() {
        InputHandler inputHandler = new InputHandler();
        Generator generator = new RandomGenerator();
        OutputHandler outputHandler = new OutputHandler();
        Race race = new Race(inputHandler.getCarNames(), inputHandler.getRounds(), generator, outputHandler);
        race.start();
    }
}
