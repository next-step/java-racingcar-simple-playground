package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.car.Car;
import domain.car.CarTestFactory;
import domain.strategy.RandomMoveStrategy;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {

    @Test
    @DisplayName("우승자들 다수의 이름을 반환하는지 테스트한다")
    void return_Winners_Names() {
        //Given
        Car normalCar = CarTestFactory.withPosition("일반차", 7);
        Car electricCar = CarTestFactory.withPosition("일렉이", 7);
        Car truck = CarTestFactory.withPosition("트럭이", 6);
        Car mini = CarTestFactory.withPosition("쪼꼬미", 7);
        List<Car> cars = List.of(normalCar, electricCar, truck, mini);

        //When
        List<String> winners = Winners.findWinnersNames(cars);

        //Then
        assertThat(winners).containsExactlyInAnyOrder("일반차", "일렉이", "쪼꼬미");
    }

    @Test
    @DisplayName("우승자 한 명의 이름을 반환하는지 테스트한다")
    void return_One_Winner_Name() {
        //Given
        Car puppy = new Car("강아지", new RandomMoveStrategy(4, 10), 7);
        Car kitty = new Car("고양이", new RandomMoveStrategy(5, 10), 6);
        Car hamster = new Car("햄스터", new RandomMoveStrategy(6, 10), 3);
        List<Car> cars = List.of(puppy, kitty, hamster);

        //When
        List<String> winners = Winners.findWinnersNames(cars);

        //Then
        assertThat(winners).containsExactlyInAnyOrder("강아지");
    }

    @Test
    @DisplayName("우승자 리스트가 비어 있을 때 빈 리스트를 반환하는지 테스트한다")
    void return_empty_List() {
        //Given
        List<Car> cars = List.of();

        //When
        List<String> winners = Winners.findWinnersNames(cars);

        //Then
        assertThat(winners).isEmpty();
    }
}
