import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import domain.Car;
import domain.RacingGame;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    @DisplayName("레이싱 게임 객체 생성 및 확인")
    public void RacingGmae_Class() {
        //given
        String names = "neo,brie,brown";
        int expectedTryCnt = 5;

        //when
        List<Car> expected = Arrays.stream(names.split(","))
                .map(Car::new)
                .toList();

        RacingGame racingGame = new RacingGame(names, expectedTryCnt);

        List<Car> players = racingGame.getPlayers();

        //then
        assertAll(() -> assertThat(racingGame.getTryCnt()).isEqualTo(expectedTryCnt),
                () -> assertThat(expected.get(0).getCarName()).isEqualTo(players.get(0).getCarName()),
                () -> assertThat(expected.get(1).getCarName()).isEqualTo(players.get(1).getCarName()),
                () -> assertThat(expected.get(2).getCarName()).isEqualTo(players.get(2).getCarName()));
    }

    @Test
    @DisplayName("(테스트 시 랜덤 시드 값 고정 필요) MovingCnt 개수 세기 확인")
    public void CountingMovingCnt_Method() {
        //given
        String names = "neo,brie,brown";
        int expectedTryCnt = 5;

        List<Car> expectedPlayer = Arrays.stream(names.split(","))
                .map(Car::new)
                .toList();

        //when
        for (int i = 0; i < expectedTryCnt; i++) {
            expectedPlayer.forEach(car-> car.moving());
        }

        RacingGame racingGame = new RacingGame(names, expectedTryCnt);
        racingGame.countingPlayerMoving();

        List<Car> players = racingGame.getPlayers();

        //then
        assertAll(() -> assertThat(expectedPlayer.get(0).getMovingCnt()).isEqualTo(players.get(0).getMovingCnt()),
                () -> assertThat(expectedPlayer.get(1).getMovingCnt()).isEqualTo(players.get(1).getMovingCnt()),
                () -> assertThat(expectedPlayer.get(2).getMovingCnt()).isEqualTo(players.get(2).getMovingCnt()));
    }

    @Test
    @DisplayName("승자 움직임 개수 확인")
    public void CountingWinnerMovingCnt_Method() {
        //given
        String names = "neo,brie,brown";
        int expectedTryCnt = 5;
        int expectedWinnerMovingCnt = 0;

        List<Car> expectedPlayer = Arrays.stream(names.split(","))
                .map(Car::new)
                .toList();

        //when
        for (int i = 0; i < expectedTryCnt; i++) {
            expectedPlayer.forEach(car-> car.moving());
        }

        final Car expectedWinner = expectedPlayer.stream()
                .max(Comparator.comparing(Car::getMovingCnt))
                .stream()
                .findAny()
                .orElseThrow();

        expectedWinnerMovingCnt = expectedWinner.getMovingCnt();

        RacingGame racingGame = new RacingGame(names, expectedTryCnt);
        racingGame.countingPlayerMoving();
        racingGame.countingWinnerMoving();

        //then
        assertThat(racingGame.getWinnerMovingCnt()).isEqualTo(expectedWinnerMovingCnt);
    }

    @Test
    @DisplayName("승자 결정 및 승자 저장 문자열 확인")
    public void DecideWinner_Method() {
        //given
        String names = "neo,brie,brown";
        int expectedTryCnt = 5;

        List<Car> expectedPlayer = Arrays.stream(names.split(","))
                .map(Car::new)
                .toList();

        //when
        for (int i = 0; i < expectedTryCnt; i++) {
            expectedPlayer.forEach(car-> car.moving());
        }

        final Car expectedWinner = expectedPlayer.stream()
                .max(Comparator.comparing(Car::getMovingCnt))
                .stream()
                .findAny()
                .orElseThrow();

        final int expectedWinnerMovingCnt = expectedWinner.getMovingCnt();

        List<String> expectedWinners = expectedPlayer.stream()
                .filter(player -> player.getMovingCnt() == expectedWinnerMovingCnt)
                .map(Car::getCarName)
                .collect(Collectors.toList());

        String expecterWinnerName = expectedWinners.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        RacingGame racingGame = new RacingGame(names, expectedTryCnt);
        racingGame.countingPlayerMoving();
        racingGame.countingWinnerMoving();
        racingGame.decideWinner();

        String WinnerName = racingGame.getWinners().stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        //then
        assertThat(WinnerName).isEqualTo(expecterWinnerName);
    }
}