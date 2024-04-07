import domain.Car;
import domain.RandomValueGenerator;
import exception.IllegalRandomVariableException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("4이상이면 전진하는지 확인한다.")
    void moveTest(){
        Car car = new Car("포르쉐");
        int beforeDistance = car.getDistance();
        for(int i=4;i<10;i++){
            car.moveOrStop(i);
            assertEquals(beforeDistance + 1, car.getDistance());
            beforeDistance = car.getDistance();
        }

    }

    @Test
    @DisplayName("10이상 이면 전진하면 안되는지 확인한다.")
    void moveTestIfOverTen(){
        Car car = new Car("제네시스");
        for(int i=10;i<16;i++){
            car.moveOrStop(i);
            assertEquals(0, car.getDistance());
        }
    }

    @Test
    @DisplayName("랜덤 생성된 수가 유효범위에 속하는지 테스트한다.")
    void moveTestWithRandomValue() {
        int randomVariable = RandomValueGenerator.generate();
        // 익셉션이 안떠야 통과
        try{
            new Car("포르쉐").moveOrStop(randomVariable);
        } catch(IllegalRandomVariableException e) {
            assertEquals("숫자가 예상 범위를 초과합니다.", e.getMessage());
        }
    }

}