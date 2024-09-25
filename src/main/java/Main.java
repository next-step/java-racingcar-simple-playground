import domain.Cars;
import domain.Game;
import domain.WinnerSelector;
import view.View;

public class Main {
    public static String inputNames;
    public static void main(String[] args) {
        startRacing();
    }

    private static void startRacing(){
        try {
            inputNames = View.inputCarName();
            Cars.splitCarName(inputNames);
            Cars.generateCar();
            Game racingame = new Game();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        View.printWinner(WinnerSelector.getWinners(Cars.cars));
    }
}
