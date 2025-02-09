import domain.Car;
import domain.Competition;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    Competition game = new Competition();

    public void game(){
        String[] carNames = InputView.getCarNames();
        int gameTime = InputView.getGameTime();

        if(isVaildNames(carNames)){
            return;
        }

        joinGame(carNames);

        System.out.println("\n실행 결과");
        for (int i=0;i < gameTime;i++){
            game.runRandomCompetition();
            ResultView.printRound(game.getCars());
        }

        ArrayList<Car> winners = game.getWinners();
        ResultView.printWinners(winners);
    }

    private boolean isVaildNames(String[] cars){
        return Arrays.stream(cars).allMatch(car -> car.length() > 5);
    }

    private void joinGame(String[] cars){
        for (String car : cars){
            game.joinCompetition(car);
        }
    }
}
