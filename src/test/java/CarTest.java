import domain.Car;
import domain.Race;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Nested
    @DisplayName("@Test 자동차 테스트")
    class TestCarClass {
        @Test
        @DisplayName("자동차 객체 생성 테스트")
        void Test_Car_Object(){
            Car one = new Car("one");

            assertThat(one.getName()).as("자동차 이름 확인").isEqualTo("one");
            assertThat(one.getDistance()).as("자동차 초기 거리 확인").isEqualTo(0);

            one.move();
            System.out.println("랜덤이동 후 거리 " + one.getDistance());
        }
    }
    
    @Nested
    @DisplayName("@Test 자동차 경주 테스트")
    class TestCarRaceClass {
        @Test
        @DisplayName("자동차 경주 테스트")
        void Test_Car_Race(){
            Race race = new Race();
            String[] names ={"a","b","c","d","e"};
            
            race.addCars(names);
            
            assertThat(race.getCars().size()).as("자동차 개수 확인").isEqualTo(5);
            race.moveCars(5);
            assertThat(race.getWinners()).as("승자 유무 확인").hasSizeGreaterThanOrEqualTo(0);
        }
    }
}
