package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void 자동차가_게임에_참여한다() {
        Game game = new Game();
        Car car = new Car("횬다이");
        game.participateGame(car);
        assertThat(game.getParticipantCars().size()).isOne();
    }

    @Test
    void 가장_많이_이동한_자동차의_이름을_확인한다() {
        Game game = new Game(
            List.of(
                new Car("자동차1"),
                new Car("자동차2"),
                new Car("자동차3")
            )
        );
        game.getParticipantCars().get(0).move(5);
        assertThat(game.getWinner().get(0).getName()).isEqualTo("자동차1");
    }
}
