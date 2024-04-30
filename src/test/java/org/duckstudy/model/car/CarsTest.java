package org.duckstudy.model.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.duckstudy.config.AppConfig;
import org.duckstudy.model.generator.RandomValueGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 경주 테스트")
class CarsTest {

    private static final String[] CAR_NAMES = new String[]{"Car1", "Car2", "Car3"};

    private Cars cars;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        RandomValueGenerator randomValueGenerator = appConfig.randomValueGenerator();
        cars = new Cars(CAR_NAMES, randomValueGenerator);
    }

    @Test
    @DisplayName("경주가 완료되면 우승자를 계산한다")
    void calculateWinnerWhenRaceIsOver() {
        int repetitionNum = 5;

        for (int i = 0; i < repetitionNum; i++) {
            cars.moveAll();
        }
        Cars winners = cars.calculateWinners();

        assertThat(winners.toList()).isSubsetOf(cars.toList());
    }
}
