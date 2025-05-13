package domain;

import java.util.*;

public class RaceHistory {
    private final List<RoundSnapshot> rounds = new ArrayList<>();

    public void addRound(List<CarSnapshot> carSnapshots) {
        rounds.add(new RoundSnapshot(carSnapshots));
    }

    public List<RoundSnapshot> getAll() {
        return List.copyOf(rounds);
    }

}
