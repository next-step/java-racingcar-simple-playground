public class Main {
    public static void main(String[] args) {
        startRacing();
    }

    private static void startRacing(){
        Cars.generateCar();
        Game newGame = new Game();
    }
}
