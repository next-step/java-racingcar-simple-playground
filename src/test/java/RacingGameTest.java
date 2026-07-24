import domain.RacingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("RacingGame 테스트")
public class RacingGameTest {

    @Test
    @DisplayName("처음에는 모든 자동차가 공동 우승")
    void AllCarAreWinner() {

        // 준비
        String[] cars = {"Player1", "Player2", "Player3"};
        RacingGame game = new RacingGame(cars);

        // 실행
        String[] result = game.getWinners();

        // 검증
        assertArrayEquals(cars, result);

    }

    @Test
    @DisplayName("라운드 진행 후 반환되는 위치 배열의 길이는 자동차 수와 같음")
    void LocationArrayLengthAndCarNumberIsSame() {

        // 준비
        String[] cars = {"Player1", "Player2", "Player3"};
        RacingGame game = new RacingGame(cars);

        // 실행
        int[] result = game.eachRound();

        // 검증
        assertEquals(3, result.length);
    }
}