package domain;

import java.util.List;

public class RoundSnapshot {
    private final List<CarSnapshot> carSnapshots;

    public RoundSnapshot(List<CarSnapshot> carSnapshots) {
        this.carSnapshots = List.copyOf(carSnapshots);
    }

    public List<CarSnapshot> getCarSnapshots() {
        return carSnapshots;
    }
}
