import static org.assertj.core.api.Assertions.assertThat;

import domain.Car;
import domain.RacingGame;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    @DisplayName("레이싱 게임 객체 생성 및 확인")
    public void RacingGmae_Class() {
        //given
        String Names = "neo,brie,brown";
        int expectedTryCnt = 5;
        int expectedWinnerMovingCnt = 0;

        //when
        Car[] expected = new Car[3];

        expected[0] = new Car("neo");
        expected[1] = new Car("brie");
        expected[2] = new Car("brown");


        RacingGame racingGame = new RacingGame(Names, expectedTryCnt);

        Car[] players = racingGame.getPlayers();

        //then
        assertThat(racingGame.getTryCnt()).isEqualTo(expectedTryCnt);
        assertThat(racingGame.getWinnerMovingCnt()).isEqualTo(expectedWinnerMovingCnt);
        assertThat(expected[0].getName()).isEqualTo(players[0].getName());
        assertThat(expected[1].getName()).isEqualTo(players[1].getName());
        assertThat(expected[2].getName()).isEqualTo(players[2].getName());
    }

    @Test
    @DisplayName("(테스트 시 랜덤 시드 값 고정 필요) MovingCnt 개수 세기 확인")
    public void CountingMovingCnt_Method() {
        //given
        String Names = "neo,brie,brown";
        int expectedTryCnt = 5;
        int expectedWinnerMovingCnt = 0;

        String expectedWinners = "";

        Car[] expectedPlayer = new Car[3];

        expectedPlayer[0] = new Car("neo");
        expectedPlayer[1] = new Car("brie");
        expectedPlayer[2] = new Car("brown");

        //when
        for (int i = 0; i < expectedTryCnt; i++) {
            for (int j = 0; j < expectedPlayer.length; j++) {
                expectedPlayer[j].addMovingCnt(expectedPlayer[j].Moving());
            }
        }

        RacingGame racingGame = new RacingGame(Names, expectedTryCnt);
        racingGame.countingPlayerMoving();

        Car[] players = racingGame.getPlayers();

        //then
        assertThat(players[0].getMovingCnt()).isEqualTo(expectedPlayer[0].getMovingCnt());
        assertThat(players[1].getMovingCnt()).isEqualTo(expectedPlayer[1].getMovingCnt());
        assertThat(players[2].getMovingCnt()).isEqualTo(expectedPlayer[2].getMovingCnt());
    }

    @Test
    @DisplayName("승자 움직임 개수 확인")
    public void CountingWinnerMovingCnt_Method() {
        //given
        String Names = "neo,brie,brown";
        int expectedTryCnt = 5;
        int expectedWinnerMovingCnt = 0;

        String expectedWinners = "";

        Car[] expectedPlayer = new Car[3];

        expectedPlayer[0] = new Car("neo");
        expectedPlayer[1] = new Car("brie");
        expectedPlayer[2] = new Car("brown");

        //when
        for (int i = 0; i < expectedTryCnt; i++) {
            for (int j = 0; j < expectedPlayer.length; j++) {
                expectedPlayer[j].addMovingCnt(expectedPlayer[j].Moving());
            }
        }

        for (int i = 0; i < expectedPlayer.length; i++) {
            if (expectedWinnerMovingCnt < expectedPlayer[i].getMovingCnt()) {
                expectedWinnerMovingCnt = expectedPlayer[i].getMovingCnt();
            }
        }

        RacingGame racingGame = new RacingGame(Names, expectedTryCnt);
        racingGame.countingPlayerMoving();
        racingGame.countingWinnerMoving();

        //then
        assertThat(racingGame.getWinnerMovingCnt()).isEqualTo(expectedWinnerMovingCnt);
    }

    @Test
    @DisplayName("승자 결정 및 승자 저장 문자열 확인")
    public void DecideWinner_Method() {
        //given
        String Names = "neo,brie,brown";
        int expectedTryCnt = 5;
        int expectedWinnerMovingCnt = 0;

        String expectedWinners = "";

        Car[] expectedPlayer = new Car[3];

        expectedPlayer[0] = new Car("neo");
        expectedPlayer[1] = new Car("brie");
        expectedPlayer[2] = new Car("brown");

        //when
        for (int i = 0; i < expectedTryCnt; i++) {
            for (int j = 0; j < expectedPlayer.length; j++) {
                expectedPlayer[j].addMovingCnt(expectedPlayer[j].Moving());
            }
        }

        for (int i = 0; i < expectedPlayer.length; i++) {
            if (expectedWinnerMovingCnt < expectedPlayer[i].getMovingCnt()) {
                expectedWinnerMovingCnt = expectedPlayer[i].getMovingCnt();
            }
        }

        for (int i = 0; i < expectedPlayer.length; i++) {
            if (expectedWinnerMovingCnt == expectedPlayer[i].getMovingCnt()) {
                expectedPlayer[i].setWin(true);
            }
        }

        for (int i = 0; i < expectedPlayer.length; i++) {
            if (expectedPlayer[i].getWin()) {
                expectedWinners = expectedPlayer[i].getName() + " ";
            }
        }

        RacingGame racingGame = new RacingGame(Names, expectedTryCnt);
        racingGame.countingPlayerMoving();
        racingGame.countingWinnerMoving();
        racingGame.decideWinner();
        racingGame.setWinners();

        Car[] players = racingGame.getPlayers();

        //then
        assertThat(players[0].getWin()).isEqualTo(expectedPlayer[0].getWin());
        assertThat(players[1].getWin()).isEqualTo(expectedPlayer[1].getWin());
        assertThat(players[2].getWin()).isEqualTo(expectedPlayer[2].getWin());

        assertThat(racingGame.getWinners()).isEqualTo(expectedWinners);
    }
}