package domain;

import java.util.*;

public class RaceHistory {
    private final List<List<CarSnapshot>> rounds = new ArrayList<>();

    public void addRound(List<CarSnapshot> roundSnapshot) {
        rounds.add(roundSnapshot);
    }

    public List<List<CarSnapshot>> getAll() {
        return List.copyOf(rounds);
    }

}
