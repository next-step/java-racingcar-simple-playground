import domain.Car;
import domain.CarName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
public class CarTest {

    @Test
    void 자동차는_이름을_가진다() {
        CarName carName = CarName.stringToName("지바겐");
        Car car = new Car(carName);
        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    void 자동차_이름이_5자_초과이면_예외() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> CarName.stringToName("abcdef"));
    }

    @Test
    void 자동차_이름이_1자_미만이면_예외() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> CarName.stringToName(""));
    }

    @Test
    void 자동차_초기_위치는_0이다() {
        Car car = new Car(CarName.stringToName("지바겐"));
        assertThat(car.getLocation()).isZero();
    }
}
