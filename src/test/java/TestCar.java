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
            //10번 동안 움직이기
            for(int i=0; i<10; i++){
                testCar.move();
            }

            //then
            //10번 동안 움직이면 0~10의 위치를 가질 수 있음
            assertThat(0 <= testCar.getLocation() && testCar.getLocation() <= 10).isTrue();
        }
    }
}
