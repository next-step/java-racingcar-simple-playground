package racingcar.domain;

import java.util.List;

public record MoveResults(List<MoveResult> results) {

    public static MoveResults create(final List<Car> cars) {
        return new MoveResults(cars.stream()
                .map(MoveResult::from)
                .toList());
    }
}
