package racingcar.domain;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static racingcar.fixture.MockNumberGenerator.Number4Generator;

import java.util.List;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class CarGroupTest {

    @Test
    void 자동차들이_움직인다() {
        CarGroup carGroup = new CarGroup(List.of(new Car("포르쉐"), new Car("아반떼")));
        carGroup.move(new Number4Generator());
        assertSoftly(softly -> {
            softly.assertThat(carGroup.cars().get(0).getPosition()).isEqualTo(1);
            softly.assertThat(carGroup.cars().get(1).getPosition()).isEqualTo(1);
        });
    }

    @Test
    void 위치가_가장_큰_자동차를_반환한다() {
        Car car = new Car("포르쉐");
        car.move(new Number4Generator());
        CarGroup carGroup = new CarGroup(List.of(car, new Car("아반떼")));
        assertSoftly(softly -> {
            softly.assertThat(carGroup.getWinners()).hasSize(1);
            softly.assertThat(carGroup.getWinners().get(0).getName()).isEqualTo("포르쉐");
            softly.assertThat(carGroup.getWinners().get(0).getPosition()).isEqualTo(1);
        });
    }
}
