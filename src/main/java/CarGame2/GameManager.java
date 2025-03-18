package CarGame2;

public class GameManager {

    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();
        OutputHandler raceOutput = new OutputHandler();
        Generator generator = new RandomGenerator();
        Race race = new Race(inputHandler.getCarNames(), inputHandler.getRounds(), generator, raceOutput);
        race.start();
    }
}
