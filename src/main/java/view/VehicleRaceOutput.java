package view;

import domain.Participant;
import domain.Race;

import java.util.List;

public class VehicleRaceOutput {
    public void showRace(Race race, int numberOfRound) {
        List<Participant> participants = race.getParticipants();
        for (int i = 0; i < numberOfRound; i++) {
            race.startOneRound();
            System.out.println("실행결과");
            showDistances(participants);
            System.out.println();
        }
    }

    private void showDistances(List<Participant> participants) {
        for (Participant participant : participants) {
            System.out.println(participant.getName() + " : " + "-".repeat(participant.getDistance()));
        }
    }

    public void showWinnerNames(Race race) {
        String winnerNames = String.join(",", race.getWinnerNames());
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

}
