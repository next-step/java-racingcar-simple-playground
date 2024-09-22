public class Application {
    public static void main(String[] args) {
        final Game raceGame = new RaceGame();

        raceGame.preparing();

        raceGame.start();

        raceGame.end();
    }
}
