package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;



public class WinnerCarsTest {
    @Test
    @DisplayName("우승카 리스트 만들기")
    void WinnerCarsTest() {
        //given
        Car car1 = new Car("CarA");//객체 생성
        Car car2 = new Car("CarB");
        Car car3 = new Car("CarC");
        car1.positionFoward(1);//위치 설정
        car2.positionFoward(3);
        car3.positionFoward(3);
        List<Car> carList = new ArrayList<>();//리스트 생성
        carList.add(car1);//리스트에 객체 추가
        carList.add(car2);
        carList.add(car3);
        WinnerCars winnerCars = new WinnerCars(carList);//객체 생성

        //When & Then
        List<Car> winningCars = winnerCars.getWinningCars();
        Assertions.assertThat(winningCars).hasSize(2);
        Assertions.assertThat(winningCars).contains(car2, car3);
        Assertions.assertThat(winningCars).doesNotContain(car1);
    }
}
