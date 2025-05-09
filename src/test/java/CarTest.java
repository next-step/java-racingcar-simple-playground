import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CarTest {

    static class FixedNumberProvider extends RandomNumberProvider {
        private final int fixedNumber;

        public FixedNumberProvider(int fixedNumber) {
            this.fixedNumber = fixedNumber;
        }

        @Override
        public int getRandomNumber() {
            return fixedNumber;
        }
    }

    @Test
    void shouldMoveWhenNumberIs4OrMore() {
        RandomNumberProvider provider = new FixedNumberProvider(5);
        Mover mover = new Mover();
        Car car = new Car("Go");

        car.move(provider, mover);

        assertThat(car.getPosition()).isEqualTo(1);
        assertThat(car.getName()).isEqualTo("Go");
        assertThat(car.getPositionDisplay()).isEqualTo("Go : -");
    }

    @Test
    void shouldNotMoveWhenNumberIsLessThan4() {
        RandomNumberProvider provider = new FixedNumberProvider(2);
        Mover mover = new Mover();
        Car car = new Car("Stop");

        car.move(provider, mover);

        assertThat(car.getPosition()).isZero();
        assertThat(car.getPositionDisplay()).isEqualTo("Stop : ");
    }
}
