package org.duckstudy.movingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.Random;
import org.duckstudy.generator.Generator;
import org.duckstudy.generator.RandomValueGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("움직이는 자동차 테스트")
class CarTest {

    private final Random random = new Random();
    private Generator generator;
    private Car car;

    @BeforeEach
    void setUp() {
        this.generator = mock(RandomValueGenerator.class);
        this.car = new Car("Test Car", generator);
    }

    @Test
    @DisplayName("random 값이 4 이상 9 이하인 경우 1만큼 전진한다")
    void moveCarWhenRandomValueIsGreaterThanOrEqual4() {
        int randomValue = 4 + random.nextInt(5);
        given(generator.generateValue()).willReturn(randomValue);

        car.move();

        assertThat(car.getPosition()).isEqualTo(1L);
    }

    @Test
    @DisplayName("random 값이 3 이하인 경우 멈춘다")
    void stopCarWhenRandomValueIsLessThan4() {
        int randomValue = random.nextInt(3);
        given(generator.generateValue()).willReturn(randomValue);

        car.move();

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
