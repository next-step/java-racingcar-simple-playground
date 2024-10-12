package controller;

import converter.RacingCarConverter;
import lombok.RequiredArgsConstructor;
import service.RacingCarService;
import view.RacingCarView;

@RequiredArgsConstructor
public class RacingCarController {

  final RacingCarView racingCarView;
  final RacingCarService racingCarService;

  int round;
  boolean isGameInit = false;

  public void set() {
    racingCarService.createRacingCar(racingCarView.inputRacingCarName().stream().map(
        RacingCarConverter::toRacingCarCreateDto).toList());
    round = racingCarView.inputRound();

    isGameInit = true;
  }

  public void run() {
    if (!isGameInit)
      throw new IllegalStateException("게임이 초기화되지 않았습니다.");

    racingCarView.printResultTitle();
    for(int currentRound = 0; currentRound < round; ++currentRound){
      racingCarService.move();
      racingCarView.printResult(racingCarService.getResults());
    }

    racingCarView.printWinner(racingCarService.getResults());

    isGameInit = false;
  }
}
