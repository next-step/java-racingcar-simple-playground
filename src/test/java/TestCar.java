import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

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
            for(int i=0; i<10; i++){
                testCar.move();
            }

            //then
            assertThat(0 <= testCar.getLocation() && testCar.getLocation() <= 10).isTrue();
        }
    }
}
