public class Main {
    public static String inputNames;
    public static void main(String[] args) {
        startRacing();
    }

    private static void startRacing(){
        inputNames = View.inputCarName();
        Cars.splitCarName(inputNames);
        Cars.generateCar();
        new Game();
        View.printWinner(WinnerSelector.getWinners(Cars.cars));
    }
}
