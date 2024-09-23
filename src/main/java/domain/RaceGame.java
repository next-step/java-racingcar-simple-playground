package domain;

import java.util.*;

public class RaceGame {

    private final Cars participants;
    private final int count;
    private int maxLength;
    private final Rule rule;


    public RaceGame(Cars cars, int tryCount, Rule rules) {
        this.participants = cars;
        this.count = tryCount;
        this.maxLength = 0;
        this.rule = rules;
    }

    public void start() {
        System.out.println("\n실행결과");
        for (int i = 0; i < count; i++) {
            for (Car participant: participants.getCars()) {
                if (rule.canGo()) {
                    participant.move();

                    if (participant.getLocation() > maxLength) {
                        maxLength = participant.getLocation();
                    }
                }
            }

            for (Car participant: participants.getCars()) {
                String position = "-".repeat(participant.getLocation());
                System.out.println(participant.getName().getValue() + " : " + position);
            }
            System.out.println();
        }
    }


    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<Car>();

        for(Car participant: participants.getCars()) {
            if (maxLength == participant.getLocation()) {
                winners.add(participant);
            }
        }

        return winners;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        RaceGame raceGame = (RaceGame) o;
//        return count == raceGame.count && maxLength == raceGame.maxLength && Objects.equals(participants, raceGame.participants) && Objects.equals(rule, raceGame.rule);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(participants, count, maxLength, rule);
//    }
}
