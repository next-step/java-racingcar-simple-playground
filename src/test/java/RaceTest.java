import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    @Test
    @DisplayName("레이스 생성 테스트")
    void newRaceTest() {
        List<Car> cars = List.of(
                new Car("AAA"),
                new Car("BBB"),
                new Car("CCC")
        );
        int expected = 3;

        Race race = new Race(cars);
        int actual = race.getCars().size();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("레이스 테스트")
    void raceTest() {
        List<Car> cars = List.of(
                new Car("AAA"),
                new Car("BBB"),
                new Car("CCC")
        );
        int rounds = 3;

        Race race = new Race(cars);
        race.raceStart(rounds);
        List<Car> winners = race.getWinners();

        assertThat(winners).hasSizeGreaterThanOrEqualTo(1);
        /*
         * 자동차의 이동이 내부 Random에 의존하기 때문에 "특정 자동차가 우승했는지"는 검증할 수가 없다.
         * 모든 자동차가 이동하지 않더라도, 공동 우승자로 되기때문에 우승자는 최소 1명 이상 존재한다는 사실만 검증이 된다.
         * 테스트 할 때는 내가 특정 자동차만 움직이게 해서 그 자동차가 우승했는지 검증할 수 있게 해야할 것이다.
         * 어떻게...?
         */
    }
}
