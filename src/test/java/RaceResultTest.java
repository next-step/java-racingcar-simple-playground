import model.Car;
import model.RacingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceResultTest {
    @Test
    @DisplayName("우승자 1명인 경우 올바르게 추출")
    public void Test_singlewinner() {
        //given:'A'와 'B'라는 자동차가 주어질때
        Car car1 = new Car("A");
        Car car2 = new Car("B");
        //when:'A'자동차는 4를 부여받고, 'B'자동차는 0을 부여받을때
        car1.move(4);
        car2.move(0);
        RacingGame racingGame=new RacingGame(List.of(car1,car2));
        List<Car> winners = racingGame.getResult();
        //Then:우승자는 A로 결정된다.
        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo("A");
    }

    @Test
    @DisplayName("공동우승자 추출")
    public void Test_multiwinners() {
        //given:'A'와 'B'라는 차가 주어질때,
        Car car1 = new Car("A");
        Car car2 = new Car("B");
        //when:'A'와 'B'모두 4숫자를 부여받을때
        car1.move(4);
        car2.move(4);
        RacingGame racingGame=new RacingGame(List.of(car1,car2));
        List<Car> winners = racingGame.getResult();
        //then:우승자는 'A','B' 모두로 결정된다
        assertThat(winners).hasSize(2);
        assertThat(winners).extracting(Car::getName).containsExactlyInAnyOrder("A", "B");
    }
}

