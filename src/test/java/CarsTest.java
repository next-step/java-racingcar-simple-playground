import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 단독 우승한다.")
    void 단독_우승자_찾기() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");

        pobi.move(() -> 4);
        crong.move(() -> 3);

        Cars cars = new Cars(Arrays.asList(pobi, crong));

        List<Car> winners = cars.findWinners();

        assertThat(winners)
                .extracting(Car::getName)
                .containsExactly("pobi");
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 여러 대일 경우 공동 우승한다.")
    void 공동_우승자_찾기() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Car loopy = new Car("loopy");

        pobi.move(() -> 4);
        crong.move(() -> 4);
        loopy.move(() -> 3);

        Cars cars = new Cars(Arrays.asList(pobi, crong, loopy));

        List<Car> winners = cars.findWinners();

        assertThat(winners)
                .extracting(Car::getName)
                .containsExactly("pobi", "crong");
    }

    @Test
    @DisplayName("NumberGenerator가 무조건 4를 반환하면 모든 자동차가 1칸씩 전진한다.")
    void 모든_자동차_전진_테스트() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Cars cars = new Cars(Arrays.asList(pobi, crong));

        NumberGenerator alwaysMoveGenerator = () -> 4;

        cars.moveAll(alwaysMoveGenerator);

        assertThat(pobi.getPosition()).isEqualTo(1);
        assertThat(crong.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("NumberGenerator가 무조건 3을 반환하면 모든 자동차가 정지한다.")
    void 모든_자동차_정지_테스트() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Cars cars = new Cars(Arrays.asList(pobi, crong));

        NumberGenerator alwaysStopGenerator = () -> 3;

        cars.moveAll(alwaysStopGenerator);

        assertThat(pobi.getPosition()).isEqualTo(0);
        assertThat(crong.getPosition()).isEqualTo(0);
    }
}