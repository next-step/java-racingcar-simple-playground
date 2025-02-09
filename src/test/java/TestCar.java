import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

@DisplayName("움직이는 자동차 테스트")
public class TestCar {

    @Nested
    @DisplayName("움직이는 자동차 기능테스트")
    class TestCarFeatures{

        @Test
        @DisplayName("이동 테스트")
        void testMove(){
            //given
            final Car testCar = new Car("test");

            //when
            //자동차 이동시키기
            int testSpeed = new Random().nextInt(10);
            testCar.move(testSpeed);

            //then
            if(testSpeed >= 4){
                assertThat(1).isEqualTo(testCar.getLocation());
                return;
            }
            assertThat(0).isEqualTo(testCar.getLocation());
        }
    }

    @Nested
    @DisplayName("움직이는 자동차 예외테스트")
    class TestCarExceptions{

        @Test
        @DisplayName("이동 예외 테스트")
        void testMoveException(){
            //given
            final Car testCar = new Car("test");

            //when
            assertThatThrownBy(()-> testCar.move(-1)).hasMessage("speed is must be between 0 and 9");
            assertThatThrownBy(()-> testCar.move(10)).hasMessage("speed is must be between 0 and 9");
        }

        @Test
        @DisplayName("차량 생성 예외 테스트")
        void testCarCreationException(){
            assertThatThrownBy(()-> new Car("123456")).hasMessage("name is must be less than 5 characters");
        }
    }
}
