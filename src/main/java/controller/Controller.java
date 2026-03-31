package controller;

import domain.Contest;
import view.applicationIOManager.ApplicationIOManager;
import view.applicationIOManager.UserInput;

public class Controller {

    public void run() {
        ApplicationIOManager IOmanager = new ApplicationIOManager();

        UserInput userInput = IOmanager.getUserInput();

        Contest contest = new Contest(userInput.getParticipants(), userInput.getAttempt());
        contest.startContest();


        String[] winners = contest.getWinners();
        IOmanager.printResult(winners);
    }
}
