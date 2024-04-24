package org.duckstudy.model.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.duckstudy.config.AppConfig;
import org.duckstudy.model.generator.RandomValueGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

    @Nested
    @DisplayName("반복 횟수 검증 테스트")
    class RepetitonNumValidationTest {
        @Test
        @DisplayName("반복 횟수가 0보다 클때 성공한다")
        void gameSuccessWhenRepetitionNumIsGreaterThan0() {
            int repetitionNum = 1;

            assertThatCode(() -> cars.validateRepetitionNum(repetitionNum))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("반복 횟수가 0 이하이면 에러가 발생한다")
        void gameFailWhenRepetitionNumIsEqualOrLessThan0() {
            int repetitionNum = 0;

            assertThatThrownBy(() -> cars.validateRepetitionNum(repetitionNum))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("자동차 경주 결과 테스트")
    class CarRaceResultTest {
        @Test
        @DisplayName("경주가 완료되면 우승자를 계산한다")
        void calculateWinnerWhenRaceIsOver() {
            int repetitionNum = 5;

            for (int i = 0; i < repetitionNum; i++) {
                cars.moveAll();
            }
            Cars winners = cars.calculateWinners();

            assertThat(winners.getAllNames()).isSubsetOf(CAR_NAMES);
        }
    }
}
