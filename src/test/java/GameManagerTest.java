import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import CarGame2.domain.service.GameManager;
import CarGame2.domain.service.Generator;
import CarGame2.controller.InputHandler;
import CarGame2.view.OutputHandler;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameManagerTest {

    private GameManager gameManager;
    private InputHandler inputHandler;
    private Generator fixedGenerator;
    private OutputHandler outputHandler;

    @BeforeEach
    void setUp() {
        inputHandler = new TestInputHandler();
        fixedGenerator = new FixedGenerator(4);
        outputHandler = new OutputHandler();
        gameManager = new GameManager(inputHandler, fixedGenerator, outputHandler);
    }

    @Test
    @DisplayName("게임이 정상적으로 실행되는지 테스트")
    void 게임_시작_테스트() {
        assertDoesNotThrow(() -> gameManager.setGame());
    }

    static class TestInputHandler extends InputHandler {
        @Override
        public List<String> getCarNames() {
            return List.of("car1", "car2", "car3");
        }

        @Override
        public int getRounds() {
            return 3;
        }
    }

    static class FixedGenerator implements Generator {
        private final int fixedValue;

        public FixedGenerator(int fixedValue) {
            this.fixedValue = fixedValue;
        }

        @Override
        public int generate() {
            return fixedValue;
        }
    }
}
