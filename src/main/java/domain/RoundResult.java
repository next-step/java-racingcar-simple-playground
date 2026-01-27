package domain;

import java.util.List;

public final class RoundResult {
    private final List<CarState> states;

    public RoundResult(List<CarState> states) {
        this.states = List.copyOf(states);
    }

    public List<CarState> states() {
        return states;
    }

    public static RoundResult from(Cars cars) {
        return new RoundResult(
                cars.getCars().stream()
                        .map(car -> new CarState(car.name(), car.position()))
                        .toList()
        );
    }

    public record CarState(String name, int position) {}
}
