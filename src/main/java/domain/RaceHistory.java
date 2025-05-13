package domain;

import java.util.*;

public class RaceHistory {
    private final List<List<CarInfo>> rounds = new ArrayList<>();

    public void addRound(List<CarInfo> roundSnapshot) {
        rounds.add(roundSnapshot);
    }

    public List<List<CarInfo>> getAll() {
        return List.copyOf(rounds);
    }

}
