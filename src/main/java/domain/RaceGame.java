package domain;

import java.util.*;

public class RaceGame {

    private final List<Car> participants;
    private final int count;
    private int maxLength;
    private final Rule rule;

    public RaceGame(String[] carNames, int tryCount, Rule rules) {
        // 생성자 안에서 class 내부 함수 쓰는것이 맞을까?
        this.participants = this.preparing(carNames);
        this.count = tryCount;
        this.maxLength = 0;
        this.rule = rules;
    }

    private List<Car> preparing(String[] carNames) {
        List<Car> participants = new ArrayList<Car>();
        for (String carName : carNames) {
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
}
