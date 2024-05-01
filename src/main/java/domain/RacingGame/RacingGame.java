package domain.RacingGame;

import domain.RacingCar.RacingCar;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<RacingCar> participants;

    public RacingGame() {
        this.participants = new ArrayList<>();
    }

    public void addParticipant(RacingCar racingCar) {
        this.participants.add(racingCar);
    }

    public int getNumberOfParticipants() {
        return participants.size();
    }

    public void race(List<Integer> randomNumbers) {
        RacingCar currentCar;
        int currentNumber;

        for (int index = 0; index < randomNumbers.size(); index++) {
            currentCar = participants.get(index);
            currentNumber = randomNumbers.get(index);

            currentCar.race(currentNumber);
        }
    }

    public List<RacingCar> getWinner() {
        return participants.stream()
            .collect(Collectors.groupingBy(
                RacingCar::getLocation,
                TreeMap::new,
                Collectors.toList()
            ))
            .lastEntry()
            .getValue();
    }

}
