package domain.RacingGame;

import domain.RacingCar.RacingCar;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<RacingCar> participants;
    private final NumberGenerator numberGenerator;

    public RacingGame(NumberGenerator numberGenerator, List<String> participantNames) {
        this.numberGenerator = numberGenerator;
        this.participants = new ArrayList<>();
        addParticipants(participantNames);
    }

    private void addParticipants(List<String> participantNames) {
        for (String name : participantNames) {
            this.participants.add(new RacingCar(name));
        }
    }

    public void race() {
        for (RacingCar participant : participants) {
            final int randomNumber = numberGenerator.generate();
            participant.race(randomNumber);
        }
    }

    public List<String> getWinner() {
        return participants.stream()
            .collect(Collectors.groupingBy(
                RacingCar::getLocation,
                TreeMap::new,
                Collectors.toList()
            ))
            .lastEntry()
            .getValue()
            .stream()
            .map(RacingCar::getName)
            .collect(Collectors.toList());
    }

    public Map<String, Integer> getLocationByName() {
        return participants.stream()
            .collect(Collectors.toMap(RacingCar::getName, RacingCar::getLocation));
    }

}
