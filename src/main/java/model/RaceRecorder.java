package model;

import java.util.ArrayList;
import java.util.List;

public class RaceRecorder {
    private final List<RaceRound> raceRounds;

    public RaceRecorder() {
        this.raceRounds = new ArrayList<>();
    }

    public void record(Cars cars) {
        raceRounds.add(new RaceRound(cars));
    }

    public List<RaceRound> getRaceRounds() {
        return List.copyOf(raceRounds);
    }
}
