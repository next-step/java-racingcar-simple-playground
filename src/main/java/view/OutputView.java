package view;

import dto.CarProgressDto;
import dto.WinnersDto;

import java.util.List;

public interface OutputView {
    void printCarNamePrompt();
    void printRoundPrompt();
    void printRacingResultMessageHeader();
    void printRoundResult(List<CarProgressDto> carResults);
    void printWinners(WinnersDto winnersDto);
}
