import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import model.Car;
import util.NumberGenerator;

public class CarTest {

    @Test
    public void 자동차가_정상적으로_움직이는지_테스트() {
        NumberGenerator fixedGenerator = new FixedGenerator();
        Car car = new Car("Car");

        car.move(fixedGenerator.generate(4));

        assertThat(car.getPos()).isEqualTo(1);
    }

    @Test
    public void 자동차가_정상적으로_정지하는지_테스트() {
        NumberGenerator fixedGenerator = new FixedGenerator();
        Car car = new Car("Car");

        car.move(fixedGenerator.generate(0));

        assertThat(car.getPos()).isEqualTo(0);
    }

    @Nested
    class FixedGenerator implements NumberGenerator {

        @Override
        public int generate(int bound) {
            return bound;
        }
    }
}
