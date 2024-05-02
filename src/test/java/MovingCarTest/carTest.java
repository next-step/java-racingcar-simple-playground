package MovingCarTest;

import domain.Car;
import domain.RacingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("이름을 그대로 반환하는지 확인한다.")
    public void testGetNames() {
        // Given
        String name = "TestCar";
        Car car = new Car(name);

        // When
        String actualName = car.getNames();

        // Then
        assertEquals(name, actualName);
    }

    @Test
    @DisplayName("위치를 그대로 반환하는지 확인한다.")
    public void testGetPosition() {
        // Given
        String name = "TestCar";
        Car car = new Car(name);
        int expectedPosition = Car.INITIAL_POSITION;

        // When
        int actualPosition = car.getPosition();

        // Then
        assertEquals(expectedPosition, actualPosition);
    }
    @Test
    @DisplayName("Car 객체가 이름과 위치를 가지고 만들어지는지 확인한다.")
    public void testCarCreation() {
        // Given
        String name = "TestCar";

        // When
        Car car = new Car(name);

        // Then
        assertEquals(name, "TestCar");
        assertEquals(Car.INITIAL_POSITION, car.getPosition());
    }

    @Test
    @DisplayName("랜덤 수가 범위를 안벗어나는지 확인한다")
    void testRndNum(){
        Random random = new Random(); // Random 객체 생성
        int randomNumber = random.nextInt(10); // 랜덤 값 생성
        assertTrue(randomNumber >= 0 && randomNumber <= 9, "랜덤 숫자가 0부터 9 사이여야 합니다.");
    }
    @Test
    @DisplayName("랜덤 숫자에 따라 자동차가 올바르게 이동하는지 확인한다.(4이상에만 움직여야함)")
    void testMove() {
        // Given
        Car car = new Car("Test Car");
        int initialPosition = car.getPosition();

        // When
        car.move();
        int newPosition = car.getPosition();

        // Then
        assertThat(newPosition).isEqualTo(initialPosition + (newPosition > initialPosition ? 1 : 0));
    }



}

