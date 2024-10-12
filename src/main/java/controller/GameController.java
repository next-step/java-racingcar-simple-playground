package controller;

import Model.RacingGame;
import validator.Validator;
import view.InputView;
import view.OutputView;
import java.util.List;


public class GameController {
  private final RacingGame racingGame= new RacingGame();

  private final InputView inputView = new InputView();
  private final OutputView outputView = new OutputView();
  private final Validator validator = new Validator();

  public void start() {

    List<String> nameList = inputView.inputNameList();
    validator.validName(nameList);

    racingGame.createCarList(nameList);

    int round = inputView.inputAttempt();
    validator.validRound(round);

    outputView.printRoundResultInfo();
    for (int i=1; i<=round; i++) {
      racingGame.run();
      outputView.printRoundResult( racingGame.getCarList() );
    }

    outputView.printWinner( racingGame.getWinnerList() );
  }
}
