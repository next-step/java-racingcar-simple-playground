import domain.RacingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("RacingGame 테스트")
public class RacingGameTest {

    String[] cars = {"Player1", "Player2", "Player3"};

    @Test
    @DisplayName("라운드 진행 후 반환되는 위치 배열의 길이는 자동차 수와 같음")
    void locationArrayLengthAndCarNumberIsSame() {

        // 준비
        String[] cars = {"Player1", "Player2", "Player3"};
        RacingGame game = new RacingGame(cars);

        // 실행
        int[] result = game.eachRound();

        // 검증
        assertEquals(3, result.length);
    }


    @Test
    @DisplayName("단일 우승자 반환")
    void oneCarIsWinner() {

        // 준비
        RacingGame game = new RacingGame(cars);
        int[] numbers1 = {9, 3, 8};
        int[] numbers2 = {5, 6, 1};
        int[] numbers3 = {4, 2, 7};

        // 실행
        game.eachRound(numbers1);
        game.eachRound(numbers2);
        game.eachRound(numbers3);
        String[] result = game.getWinners();

        // 검증
        assertArrayEquals(new String[]{"Player1"}, result);
    }


    @Test
    @DisplayName("공동 우승자 반환")
    void severalCarsAreWinner() {

        // 준비
        RacingGame game = new RacingGame(cars);
        int[] numbers1 = {9, 4, 8};
        int[] numbers2 = {5, 6, 1};
        int[] numbers3 = {3, 2, 7};

        // 실행
        game.eachRound(numbers1);
        game.eachRound(numbers2);
        game.eachRound(numbers3);
        String[] result = game.getWinners();

        // 검증
        assertArrayEquals(new String[]{"Player1", "Player2", "Player3"}, result);
    }
}