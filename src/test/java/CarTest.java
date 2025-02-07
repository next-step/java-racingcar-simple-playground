import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CarTest {

    @Nested
    class Step1 {

        @Test
        @DisplayName("positive - 4 이상의 수일 경우 자동차가 움직인다.")
        void move() {
            Car car = spy(new Car("차"));
            doReturn(4).when(car).getRandomInt();
            car.move();
            assertThat(car.getPosition()).isEqualTo(1);
        }

        @Test
        @DisplayName("positive - 4 보다 작을 수일 경우 자동차가 움직이지 않는다.")
        void doNotMove() {
            Car car = spy(new Car("차차"));
            doReturn(3).when(car).getRandomInt();
            car.move();
            assertThat(car.getPosition()).isEqualTo(0);
        }

        @Test
        @DisplayName("negative - 이름이 null 혹은 Empty 경우 예외처리")
        void nameException() {
            assertThrows(IllegalArgumentException.class, () -> new Car(null));
            assertThrows(IllegalArgumentException.class, () -> new Car(""));
        }
    }
}
