package org.duckstudy.movingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("움직이는 자동차 테스트")
class CarMoverTest {

    private final Random random = new Random();
    private RandomValueGenerator randomValueGenerator;
    private CarMover carMover;
    private Car car;

    @BeforeEach
    void setUp() {
        randomValueGenerator = mock(RandomValueGenerator.class);
        carMover = new CarMover(randomValueGenerator);
        car = new Car("Test Car");
    }

    @Test
    @DisplayName("random 값이 4 이상 9 이하인 경우 1만큼 전진한다")
    void moveCarWhenRandomValueIsGreaterThanOrEqual4() {
        int randomValue = 4 + random.nextInt(5);
        given(randomValueGenerator.generateRandomValue()).willReturn(randomValue);

        carMover.move(car);

        assertThat(car.getPosition()).isEqualTo(1L);
    }

    @Test
    @DisplayName("random 값이 3 이하인 경우 멈춘다")
    void stopCarWhenRandomValueIsLessThan4() {
        int randomValue = random.nextInt(3);
        given(randomValueGenerator.generateRandomValue()).willReturn(randomValue);

        carMover.move(car);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
