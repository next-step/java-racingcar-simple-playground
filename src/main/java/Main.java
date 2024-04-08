import controller.Racing;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Racing racing = new Racing();

        ArrayList<String> names = inputView.getNames();
        int raceCount = inputView.getGameNum();

        racing.racing(names.size(), raceCount, names);

        List<String> winners = racing.findWinners();

        resultView.printWinners(winners);
    }
}
