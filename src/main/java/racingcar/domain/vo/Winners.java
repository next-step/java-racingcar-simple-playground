package racingcar.domain.vo;

import racingcar.domain.Car;

import java.util.List;

public record Winners(List<Car> value) {
    public int countWinners() {
        return value.size();
    }
}
