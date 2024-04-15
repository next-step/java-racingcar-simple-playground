import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("randomNumber가_4이상이면_자동차가_움직인다")
    void randomNumber가_4이상이면_자동차가_움직인다(){
        TestRandomNumber randomNumber = new TestRandomNumber(5);
        Car testCar = new Car("자동차1", randomNumber);
        testCar.move();
        assertThat(testCar.getScore()).isEqualTo(1);
    }

    @Test
    @DisplayName("randomNumber가_3이하이면_움직이지_않는다")
    void randomNumber가_3이하이면_움직이지_않는다(){
        TestRandomNumber randomNumber = new TestRandomNumber(2);
        Car testCar = new Car("자동차2", randomNumber);
        testCar.move();
        assertThat(testCar.getScore()).isEqualTo(0);
    }

    class TestRandomNumber extends RandomNumberGenerator {
        private final int number;
        
        public TestRandomNumber(int number){
            this.number = number;
        }
        @Override
        public int generate(){
            return number;
        }
    }
}
