package domain;

import view.ContestIOManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Contest {
    private final List<Car> participants = new ArrayList<>();
    private final int attempt;
    private String[] winners;
    private final ContestIOManager iOManager = new ContestIOManager();
    private final Random random = new Random();

    public Contest(String[] names, int attempt) {

        for (String name : names) {
            participants.add(new Car(name));
        }
        this.attempt = attempt;
    }

    private int getRandomValue() {
        return random.nextInt(10);
    }

    public void startContest() {
        iOManager.printStart();
        for (int i = 0; i < attempt; i++) {
            this.attemptOnce();
        }

        this.winners = findWinners(this.participants);
    }

    public void attemptOnce() {
        for (Car participant : participants) {
            participant.moveCar(getRandomValue());
        }
        iOManager.printResult(participants);
    }

    private String[] findWinners(List<Car> participants) {
        int maxPosition = participants.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return participants.stream()
                .filter(participant -> participant.getPosition() == maxPosition)
                .map(Car::getName)
                .toArray(String[]::new);
    }

    public String[] getParticipantsName() {
        String[] names = new String[this.participants.size()];

        for (int i = 0; i < this.participants.size(); i++) {
            names[i] = this.participants.get(i).getName();
        }

        return names;
    }

    public String[] getWinners() {
        return this.winners;
    }


}
