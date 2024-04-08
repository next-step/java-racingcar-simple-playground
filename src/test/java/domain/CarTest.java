import domain.Car;
import exception.CarException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.RandomValueGenerator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("랜덤 생성된 0~9의 수로 자동차가 제대로 작동하는지 확인한다.")
    void moveTestWithRandomValue() {
        Car car = new Car("제네시스");
        int value = RandomValueGenerator.generate();
        int beforeDistance = car.getDistance();
        car.moveOrStop(value);

        if(value >= 4 && value <= 9){
            assertEquals(beforeDistance + 1, car.getDistance());
        }
        if(value < 4 || value > 9){
            assertEquals(beforeDistance, car.getDistance());
        }
    }

    @DisplayName("자동차 이름이 6자 이상일 때, 자동차가 생성되지 않는지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"어코드하이브리드", "제네시스GV80", "현대팰리세이드", "기아스포티지"})
    void createCarIfNameOverSix(String carName) {
        // 자동차 생성 시 예외 발생하는 지 테스트
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(CarException.class)
                .hasMessageStartingWith("이름은 최소 ")
                .hasMessageEndingWith("자 입니다.");
    }

}
