package movingCarGame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import movingCarGame.domain.Car;
import movingCarGame.domain.CarGame;
import movingCarGame.util.FixedRandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarGameTest {

    @Test
    @DisplayName("play 실행 시 모든 자동차의 move 호출 테스트")
    void testPlay() {
        FixedRandomGenerator random = new FixedRandomGenerator(5);

        Car a = new Car("a");
        Car b = new Car("b");

        CarGame game = new CarGame(List.of(a, b), random);
        game.play();

        assertThat(a.getDistance()).isEqualTo(1);
        assertThat(b.getDistance()).isEqualTo(1);
    }


    @Test
    @DisplayName("우승자 추출 테스트")
    void testPrintWinning() {
        FixedRandomGenerator random = new FixedRandomGenerator(5);

        Car a = new Car("a");
        Car b = new Car("b");

        CarGame game = new CarGame(List.of(a, b), random);
        game.play();

        List<Car> output = game.getWinners();

        assertThat(output).extracting(Car::getName)
                .containsExactly("a", "b");
    }
}
