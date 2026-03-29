package controller;

import view.OutputView;

import java.util.List;
import java.util.Map;

public class MockOutputView extends OutputView {
    private int printWinnersExecuteCount = 0;
    private int printCurrentRaceStateExecuteCount = 0;

    @Override
    public void printWinners(List<String> winners) {
        printWinnersExecuteCount++;
        super.printWinners(winners);
    }

    @Override
    public void printCurrentRaceState(Map<String, List<Integer>> currentRaceState) {
        printCurrentRaceStateExecuteCount++;
        super.printCurrentRaceState(currentRaceState);
    }

    public int getPrintWinnersExecuteCount() {
        return printWinnersExecuteCount;
    }

    public int getPrintCurrentRaceStateExecuteCount() {
        return printCurrentRaceStateExecuteCount;
    }
}

