import domain.GameManage;
import domain.Cars;
import domain.Winners;
import view.InputView;
import view.ResultView;


public class Main {
    public static void main(String[] args) {
        Cars cars = InputView.inputCarName();
        int roundCount = InputView.inputRound();
        GameManage game = new GameManage(cars);
        for (int i = 0; i < roundCount; i++) {
            game.raceOneRound();
            ResultView.printRoundResult(cars.getCars());
        }
        Winners winners = game.createWinners();
        ResultView.printWinners(winners.getWinners());
    }
}
