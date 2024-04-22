package org.duckstudy.model.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import org.duckstudy.model.generator.Generator;
import org.duckstudy.model.generator.RandomValueGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("움직이는 자동차 테스트")
class CarTest {

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
        given(generator.generateValue()).willReturn(4);

        car.move();

        assertThat(car.getPosition()).isEqualTo(1L);
    }

    @Test
    @DisplayName("random 값이 3 이하인 경우 멈춘다")
    void stopCarWhenRandomValueIsLessThan4() {
        given(generator.generateValue()).willReturn(3);

        car.move();

        assertThat(car.getPosition()).isEqualTo(0);
    }
}