import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingcarGameTest {
    /*
    * 우승 자동차 구하기 로직 테스트
    * */
    @Test
    void 공동_우승자가_없을_때() {
        //Given(준비)
        RacingcarGame testGame = new RacingcarGame();
        Car car1 = new Car("car1"); Car car2 = new Car("car2"); Car car3 = new Car("car3");
        car1.move(3); car2.move(2); car3.move(5);
        testGame.addCar(car1); testGame.addCar(car2); testGame.addCar(car3);

        //When(실행)
        ArrayList<Car> carList = testGame.getWinner();

        //Then(검증)
        Car car = carList.get(0);
        assertEquals(car3, car);
    }
    @Test
    void 공동_우승자가_있을_때() {
        //Given(준비)
        RacingcarGame testGame = new RacingcarGame();
        Car car1 = new Car("car1"); Car car2 = new Car("car2"); Car car3 = new Car("car3");
        car1.move(3); car2.move(5); car3.move(7);
        testGame.addCar(car1); testGame.addCar(car2); testGame.addCar(car3);

        //When(실행)
        ArrayList<Car> winnerCarsList = testGame.getWinner();

        //Then(검증)
        Car winner1 = winnerCarsList.get(0);
        assertEquals(car2, winner1);
        Car winner2 = winnerCarsList.get(1);
        assertEquals(car3, winner2);
    }

    /*
    * 자동차 이름 입력받기 테스트
    * */
    @Test void 이름이_5자_이하인_경우() {
        //Given
        RacingcarGame racingcarGame = new RacingcarGame();
        String name = "1234";
        //When
        boolean result = racingcarGame.checkNameLength(name);
        //Then
        assertThat(result).isTrue();
    }
    @Test void 이름이_5자_이상인_경우() {
        //Given
        RacingcarGame racingcarGame = new RacingcarGame();
        String name = "123456";
        //When
        boolean result = racingcarGame.checkNameLength(name);
        //Then
        assertThat(result).isFalse();
    }
    @Test void 이름이_5자인_경우() {
        //Given
        RacingcarGame racingcarGame = new RacingcarGame();
        String name = "12345";
        //When
        boolean result = racingcarGame.checkNameLength(name);
        //Then
        assertThat(result).isTrue();
    }
}