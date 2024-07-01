package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

class GameControllerTest {

    @Test
    void parseCarNames() {
        GameController controller = new GameController();

        assertThat(controller.parseCarNames("neo,brie,brown"))
            .containsExactlyInAnyOrder(
                new Car("neo"),
                new Car("brie"),
                new Car("brown")
            );
    }
}
