package domain;

import java.util.List;
import java.util.stream.Collectors;

public class RaceGame {

    private final List<Car> participants;
    private final int count;
    private int maxLength;
    private final Rule rule;


    public RaceGame(List<Car> cars, int tryCount, Rule rules) {
        this.participants = cars;
        this.count = tryCount;
        this.maxLength = 0;
        this.rule = rules;
    }

    public void start() {
        for (int i = 0; i < count; i++) {
            moveOneCycle();
            showOneCycleResult();
        }
    }

    private void moveOneCycle() {
        for (Car participant : participants) {
            moveParticipantCar(participant);
        }
    }

    private void moveParticipantCar(Car participant) {
        if (rule.canGo()) {
            participant.move();

            if (participant.getLocation() > maxLength) {
                maxLength = participant.getLocation();
            }
        }
    }

    private void showOneCycleResult() {
        for (Car participant : participants) {
            String position = "-".repeat(participant.getLocation());
            System.out.println(participant.getName().getValue() + " : " + position);
        }
        System.out.println();
    }


    public List<Car> getWinners() {
        return participants
                .stream()
                .filter(p -> p.getLocation() == maxLength)
                .collect(Collectors.toList());
    }

}
