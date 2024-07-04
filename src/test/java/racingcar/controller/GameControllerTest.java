package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

class GameControllerTest {

    @Test
    void parseCarNames() {
        GameController controller = new GameController();

        try {
            Method privateMethod = controller.getClass().getDeclaredMethod("parseCarNames", String.class);
            privateMethod.setAccessible(true);

            List<Car> result = (List<Car>)privateMethod.invoke(controller, "neo,brie,brown");

            assertThat(result)
                .containsExactlyInAnyOrder(
                    new Car("neo"),
                    new Car("brie"),
                    new Car("brown")
                );

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
