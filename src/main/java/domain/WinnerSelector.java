package domain;

import java.util.List;

public final class WinnerSelector {

    public List<String> select(Cars cars) {
        int max = cars.maxPosition();
        return cars.findByPosition(max).stream()
                .map(Car::name)
                .toList();
    }
}
