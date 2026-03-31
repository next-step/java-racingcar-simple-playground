package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarGameTest {

    NumberGenerator Move = () -> 4;
    NumberGenerator Stop = () -> 2;
    Random random = new Random();
    NumberGenerator randomGen = () -> random.nextInt(10);

    @Test
    @DisplayName("모든 차가 똑같이 전진할 때")
    public void allMove() {
        CarGame carGame = new CarGame();
        carGame.createCar(List.of("choeun", "sieun", "sanghun"));

        carGame.racing(List.of(Move, Move, Move));

        List<String> winner = carGame.winner();
        assertThat(winner).contains("choeun", "sieun", "sanghun");
    }

    @Test
    @DisplayName("한 대만 전진하고 나머지는 중간에 멈출 때")
    public void oneWinner() {
        CarGame carGame = new CarGame();
        carGame.createCar(List.of("choeun", "sieun", "sanghun"));
        carGame.racing(List.of(Move, randomGen, randomGen));

        List<String> winner = carGame.winner();
        assertThat(winner).contains("choeun");
    }

    @Test
    @DisplayName("모든 차가 멈출 때")
    public void allStop() {
        CarGame carGame = new CarGame();
        carGame.createCar(List.of("choeun", "sieun", "sanghun"));
        carGame.racing(List.of(Stop, Stop, Stop));

        assertThatThrownBy(carGame::winner).isInstanceOf(IllegalStateException.class);
    }
}