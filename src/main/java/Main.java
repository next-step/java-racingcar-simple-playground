import domain.Cars;
import controller.Game;
import domain.WinnerSelector;
import view.View;

public class Main {
    public static void main(String[] args) {
        final String inputNames = View.inputCarName();;
        final int tryCount = View.inputTryCount();

        try {
            Cars.splitCarName(inputNames);
            Cars.generateCar();
            Game racingame = new Game(tryCount);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        View.printWinner(WinnerSelector.getWinners(Cars.cars));
    }
}
