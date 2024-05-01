package org.duckstudy.model.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 경주 테스트")
class CarsTest {

    @Test
    @DisplayName("경주가 완료되면 우승자를 계산한다")
    void calculateWinnerWhenRaceIsOver() {
        Cars cars = new Cars(Arrays.asList(
                new Car("Car1", 1, () -> false),
                new Car("Car2", 0, () -> false),
                new Car("Car3", 1, () -> false)
        ));

        Cars winners = cars.calculateWinners();

        assertAll(
                () -> assertThat(winners.toList()).hasSize(2),
                () -> assertThat(winners.toList()).extracting("name")
                        .containsExactly("Car1", "Car3")
        );
    }
}
