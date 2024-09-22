package domain;

import java.util.*;

public class RaceGame {

    private final List<Car> participants;
    private final int count;
    private int maxLength;
    private final Rule rule;


    // exception이 생선자에서 사용되도 되나
    public RaceGame(List<CarName> carNames, int tryCount, Rule rules) throws Exception {
        // 생성자 안에서 class 내부 함수 쓰는것이 맞을까?
        this.participants = this.preparing(carNames);
        this.count = tryCount;
        this.maxLength = 0;
        this.rule = rules;
    }

    private List<Car> preparing(List<CarName> carNames) throws Exception {
        List<Car> participants = new ArrayList<Car>();
        for (CarName carName : carNames) {
            participants.add(new Car(carName));
        }

        return participants;
    }
    public void start() {
        for (int i = 0; i < count; i++) {
            for (Car participant: participants) {
                if (rule.canGo()) {
                    participant.move();

                    if (participant.location > maxLength) {
                        maxLength = participant.location;
                    }
                }
            }

            for (Car participant: participants) {
                String position = "-".repeat(participant.location);
                System.out.println(participant.name + " : " + position);
            }
            System.out.println();
        }
    }


    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<Car>();

        for(Car participant: participants) {
            if (maxLength == participant.location) {
                winners.add(participant);
            }
        }

        return winners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceGame raceGame = (RaceGame) o;
        return count == raceGame.count && maxLength == raceGame.maxLength && Objects.equals(participants, raceGame.participants) && Objects.equals(rule, raceGame.rule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participants, count, maxLength, rule);
    }
}
