package racingcar.model;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class WinnerCarsTest {
    @Test
    void 우승카_리스트_만들기() {
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

        //When
        List<Car> winningCars = winnerCars.getWinningCars();

        //Then
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(winningCars).hasSize(2);
        softly.assertThat(winningCars).contains(car2, car3);
        softly.assertThat(winningCars).doesNotContain(car1);
        softly.assertAll();
    }
}
