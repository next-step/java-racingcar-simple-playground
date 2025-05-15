package controller;

import domain.*;
import dto.CarProgressDto;
import dto.WinnersDto;
import utils.CarNameParser;
import utils.CarProgressDtoMapper;
import utils.RoundParser;
import utils.WinnersDtoMapper;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public RacingGameController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        Cars cars = readCarsFromInput();
        int roundCount = readRoundCountFromInput();
        RacingGame game = new RacingGame(cars, numberGenerator);

        outputView.printRacingResultMessageHeader();
        playRounds(game, roundCount);
        printWinners(game);
    }

    private Cars readCarsFromInput() {
        outputView.printCarNamePrompt();
        String carNameInput = inputView.readCarName();
        List<Name> names = CarNameParser.parse(carNameInput);
        return new Cars(names.stream().map(Car::new).toList());
    }

    private int readRoundCountFromInput() {
        outputView.printRoundPrompt();
        int roundInput = RoundParser.parse(inputView.readRound());
        return new Round(roundInput).getValue();
    }

    private void playRounds(RacingGame game, int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            game.playOneRound();
            List<CarProgressDto> carResults = CarProgressDtoMapper.from(game.getCars());
            outputView.printRoundResult(carResults);
        }
    }

    private void printWinners(RacingGame game) {
        WinnersDto winnersDto = WinnersDtoMapper.from(game.getWinners());
        outputView.printWinners(winnersDto);
    }
}
