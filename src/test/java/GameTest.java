import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GameTest {

    @Nested
    class Step2 {

        @Test
        @DisplayName("positive - 우승자를 정상적으로 구한다.")
        void determineWinners() { // FIXME : Game 내부에서 Car 객체가 생성되는 것을 mockConstruction로 감지하여 처리할 수 있지만, 복잡함. 다른 방법 강구해야함.
            Game game = new Game(List.of("차1", "차2", "차3"), 1);
            List<Car> spyCars = game.getCars().stream()
                .map(Mockito::spy)
                .toList();
            doReturn(5).when(spyCars.get(0)).getRandomInt();
            doReturn(5).when(spyCars.get(1)).getRandomInt();
            doReturn(3).when(spyCars.get(2)).getRandomInt();

            game.play();
            List<Car> winners = game.getWinners();

            assertThat(winners).hasSize(2);
            assertThat(winners).extracting(Car::getName).containsExactlyInAnyOrder("차1", "차2");
        }

        @Test
        @DisplayName("negative - 라운드가 0 이하일 경우 예외 발생")
        void roundException() {
            List<String> carNames = List.of("차1", "차2", "차3");
            assertThrows(IllegalArgumentException.class, () -> new Game(carNames, 0));
            assertThrows(IllegalArgumentException.class, () -> new Game(carNames, -1));
        }
    }
}
