package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarsTest {
    private static final int MOVABLE_NUMBER = 4;
    private static final int NON_MOVABLE_NUMBER = 3;

    @Test
    @DisplayName("우승자 구하는 기능: 단독 우승자를 정상적으로 구하는지 확인")
    void get_SingleWinner() {
        //given
        Cars cars = new Cars(List.of("winner1", "loser1", "loser2", "loser3"));
        List<Car> carList = cars.getCars();
        //when
        carList.get(0).moveForward(() -> MOVABLE_NUMBER);
        carList.get(1).moveForward(() -> NON_MOVABLE_NUMBER);
        carList.get(2).moveForward(() -> NON_MOVABLE_NUMBER);
        carList.get(3).moveForward(() -> NON_MOVABLE_NUMBER);
        List<Car> winners = cars.getWinners();
        //then
        assertThat(winners).extracting(Car::getName).containsExactly("winner1");
    }

    @Test
    @DisplayName("우승자 구하는 기능: 공동 우승자를 정상적으로 구하는지 확인")
    void get_MultiWinner() {
        //given
        Cars cars = new Cars(List.of("winner1", "winner2", "loser1", "loser2"));
        List<Car> carList = cars.getCars();
        //when
        carList.get(0).moveForward(() -> MOVABLE_NUMBER);
        carList.get(1).moveForward(() -> MOVABLE_NUMBER);
        carList.get(2).moveForward(() -> NON_MOVABLE_NUMBER);
        carList.get(3).moveForward(() -> NON_MOVABLE_NUMBER);
        List<Car> winners = cars.getWinners();
        //then
        assertThat(winners).extracting(Car::getName).containsExactly("winner1", "winner2");
    }
}
