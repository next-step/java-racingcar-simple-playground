package domain.RacingGame;

import domain.RacingCar.RacingCar;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import util.Errors;

public class RacingGame {

    private final List<RacingCar> participants;
    private final NumberGenerator numberGenerator;

    public RacingGame(NumberGenerator numberGenerator, List<String> participantNames) {
        this.numberGenerator = numberGenerator;
        this.participants = initParticipants(participantNames);
    }

    private List<RacingCar> initParticipants(List<String> participantNames) {
        List<RacingCar> participants = new ArrayList<>();
        for (String name : participantNames) {
            participants.add(new RacingCar(name));
        }
        return participants;
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
            .collect(Collectors.toMap(
                RacingCar::getName,
                RacingCar::getLocation,
                (existing, replacement) -> existing,
                LinkedHashMap::new
            ));
    }
}
