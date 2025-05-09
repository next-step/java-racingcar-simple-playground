import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("4이상의 숫자를 받았을 때 전진")
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
    @DisplayName("3미만의 숫자를 받았을 때 멈춤")
    void shouldNotMoveWhenNumberIsLessThan4() {
        RandomNumberProvider provider = new FixedNumberProvider(2);
        Mover mover = new Mover();
        Car car = new Car("Stop");

        car.move(provider, mover);

        assertThat(car.getPosition()).isZero();
        assertThat(car.getPositionDisplay()).isEqualTo("Stop : ");
    }
}
