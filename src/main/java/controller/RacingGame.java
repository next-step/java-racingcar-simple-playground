package controller;

import domain.CarRacing;
import domain.NumberGenerator;
import java.util.List;
import view.InputView;
import view.ResultView;

public class RacingGame {

  private final InputView inputView;
  private final ResultView resultView;
  private final NumberGenerator numberGenerator;

  public RacingGame(InputView inputView, ResultView resultView, NumberGenerator numberGenerator) {
    this.inputView = inputView;
    this.resultView = resultView;
    this.numberGenerator = numberGenerator;
  }


  public void run() {
    // 입력 처리
    List<String> carNames = inputView.inputCars();
    int attempts = inputView.getAttempts();

    // 게임 준비
    CarRacing racing = new CarRacing(carNames, attempts, numberGenerator);
    resultView.printStart();

    // 게임 진행
    playRounds(attempts, racing);

    // 결과 출력
    List<String> winners = racing.findWinners();
    resultView.printWinners(winners);
  }

  private void playRounds(int attempts, CarRacing racing) {
    for (int round = 1; round <= attempts; round++) {
      racing.playRound();
      resultView.printRound(racing.getCars());
    }
  }
}
