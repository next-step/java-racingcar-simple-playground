package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CarMoveTest {

    private CarMove carMove;
    private  Car car;
    private RandomGenerator randomGenerator;

    @BeforeEach
    void setUp() {
        randomGenerator = Mockito.mock(RandomGenerator.class); // Mock 객체 생성
        carMove = new CarMove(randomGenerator);  // CarMove에 Mock 전달
        car = new Car("TestCar");  // Test용 Car 객체 생성
    }


    @Test
    @DisplayName("4 이상일 때 자동차 움직임 테스트")
    void moveCarTest1(){
        //given 잘모르겠다
        Mockito.when(randomGenerator.getRandomNumber()).thenReturn(5);  // Mock 설정

        //when
        carMove.moveCar(car);

        //then
        Assertions.assertThat(car.getPosition()).isEqualTo(1);

    }

    @Test
    @DisplayName("4 미만일 때 자동차 움직임 테스트")
    void moveCarTest2(){
        //given
        Mockito.when(randomGenerator.getRandomNumber()).thenReturn(1);  // Mock 설정

        //when
        carMove.moveCar(car);

        //then
        Assertions.assertThat(car.getPosition()).isEqualTo(0);

    }

}