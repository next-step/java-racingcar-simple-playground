import domain.Car;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차는 이름을 가진다.")
    void shouldMakeCarObject_WithValidName() {
        String carName = "neo";
        Car car = new Car(carName);

        assertThat(car.getCarName()).isEqualTo(carName);
    }

    @Test
    @DisplayName("자동차는 초기 위치가 0이다.")
    void shouldInitializePosition_WithZero() {
        Car car = new Car("neo");
        int position = car.getPosition();

        assertThat(position).isZero();
    }

    @Test
    @DisplayName("move() 호출 시 위치가 1 증가한다.")
    void shouldAddPosition_WhenMoveCalled() {
        Car car = new Car("neo");
        int position = car.getPosition();
        car.move();

        assertThat(car.getPosition()).isEqualTo(position + 1);
    }

    @Test
    @DisplayName("같은 위치에 있는 자동차는 isEqualPosition() 반환값이 true이다.")
    void shouldReturnTrue_WhenPositionIsEqual() {
        Car car1 = new Car("neo", 3);
        Car car2 = new Car("brie", 3);

        assertThat(car1.isEqualPosition(car2)).isTrue();
    }

    @Test
    @DisplayName("다른 위치에 있는 자동차는 isEqualPosition() 반환값이 false이다.")
    void shouldReturnFalse_WhenPositionIsNotEqual() {
        Car car1 = new Car("neo", 0);
        Car car2 = new Car("brie", 3);

        assertThat(car1.isEqualPosition(car2)).isFalse();
    }

    @Test
    @DisplayName("comparePositionOfCarObject()는 position이 높은 자동차를 더 큰 값으로 비교한다.")
    void shouldComparePosition() {
        Car car1 = new Car("neo", 3);
        Car car2 = new Car("brie", 5);
        Car car3 = new Car("brown", 3);

        assertThat(Car.comparePositionOfCarObject(car1, car2)).isLessThan(0);
        assertThat(Car.comparePositionOfCarObject(car2, car1)).isGreaterThan(0);
        assertThat(Car.comparePositionOfCarObject(car1, car3)).isEqualTo(0);
    }

}
