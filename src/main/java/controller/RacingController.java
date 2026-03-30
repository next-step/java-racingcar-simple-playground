package controller;

import model.RacingGame;
import model.RandomNumberGenerator;
import view.InputView;
import view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingController {

    public void run(){
        String inputCarNames = InputView.getCarNames();
        validateRawInput(inputCarNames);
        List<String> carNames = Arrays.stream(inputCarNames.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        String inputTryCount = InputView.getTryCount();
        int tryCount = parseAndValidateTryCount(inputTryCount);

        // 2. 게임 세팅
        RacingGame racingGame = new RacingGame(carNames, tryCount);
        RandomNumberGenerator randomGenerator = new RandomNumberGenerator();

        // 3. 게임 실행
        ResultView.printRaceStart();
        while (!racingGame.isEnd()) {
            racingGame.playOneRound(randomGenerator);
            ResultView.printStepResult(racingGame.getCars());
        }

        // 4. 최종 우승자 출력
        ResultView.printWinners(racingGame.getWinners());
    }

    private void validateRawInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 입력되지 않았습니다.");
        }
    }

    private int parseAndValidateTryCount(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수가 입력되지 않았습니다.");
        }

        try {
            int count = Integer.parseInt(input.trim());

            if (count <= 0) {
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상의 숫자여야 합니다.");
            }

            return count;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자만 입력 가능합니다.");
        }
    }
    }

