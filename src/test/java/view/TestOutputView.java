package view;

import dto.CarProgressDto;
import dto.WinnersDto;

import java.util.ArrayList;
import java.util.List;

public class TestOutputView implements OutputView {

    public final List<String> messages = new ArrayList<>();
    public final List<List<CarProgressDto>> roundResults = new ArrayList<>();
    public WinnersDto winners;

    @Override
    public void printCarNamePrompt() {
        messages.add("printCarNamePrompt");
    }

    @Override
    public void printRoundPrompt() {
        messages.add("printRoundPrompt");
    }

    @Override
    public void printRacingResultMessageHeader() {
        messages.add("printRacingResultMessageHeader");
    }

    @Override
    public void printRoundResult(List<CarProgressDto> carResults) {
        roundResults.add(new ArrayList<>(carResults));
    }

    @Override
    public void printWinners(WinnersDto winnersDto) {
        this.winners = winnersDto;
    }
}
