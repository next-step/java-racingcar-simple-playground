package model;

import components.CyclingNumberGenerator;
import constants.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    Car testCar;

    @Test
    @DisplayName("자동차는 이름을 가진다")
    protected void testCarHasName() {
        // given
        testCar = new Car("Bob");

        //result
        Assertions.assertEquals("Bob", testCar.getName());
    }
    @Test
    @DisplayName("자동차는 4 미만일 때 전진하지 않는다.")
    protected void testCarMovesDoesNotMoveProperly() {
        //given
        this.testCar = new Car("car", new CyclingNumberGenerator(new int[] {0}));

        // when
        testCar.move();

        // result
        Assertions.assertEquals(0, testCar.getDistance());
    }

    @Test
    @DisplayName("자동차는 4 이상일 때 앞으로 전진한다.")
    protected void testCarMovesProperly() {
        //given
        this.testCar = new Car("car", new CyclingNumberGenerator(new int[] {4}));

        for (int i = 1; i <= 2; i++) {
            // when
            testCar.move();
            // result
            Assertions.assertEquals(i, testCar.getDistance());
        }
    }

    @Test
    @DisplayName("이름이 5글자를 초과하면 안된다.")
    protected void testParseIntoNamesWithLongName() {
        //given
        String testName = "SixLet";

        Exception err = Assertions.assertThrows(IllegalArgumentException.class,() -> new Car(testName));
        Assertions.assertEquals(ErrorMessage.NAME_TOO_LONG, err.getMessage());
    }
}
