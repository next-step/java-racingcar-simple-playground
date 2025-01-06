import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @Nested
    @DisplayName("@Test 자동차 테스트")
    class TestCarClass {
        @Test
        @DisplayName("자동차 객체 생성 테스트")
        void Test_Car_Object(){
            Car one = new Car("one");

            assertThat(one.getName()).as("자동차 이름 확인").isEqualTo("one");
            assertThat(one.distance).as("자동차 초기 거리 확인").isEqualTo(0);

            one.move();
            System.out.println("랜덤이동 후 거리 " + one.distance);
        }
    }
}
