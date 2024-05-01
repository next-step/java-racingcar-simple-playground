package org.duckstudy.model.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 경주 테스트")
class CarsTest {

    @Test
    @DisplayName("경주가 완료되면 우승자를 계산한다")
    void calculateWinnerWhenRaceIsOver() {
        Cars cars = new Cars(Arrays.asList(
                new Car("Car1", () -> true),
                new Car("Car2", () -> false),
                new Car("Car3", () -> true)
        ));
        cars = cars.moveAll();

        Cars winners = cars.calculateWinners();

        assertThat(winners.toList().size()).isEqualTo(2);
        assertThat(winners.toList()).extracting("name")
                .containsExactly("Car1", "Car3");
    }
}
