package controller;

import common.FakeRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.RaceOutputView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static fixture.FakeNumber.winnersNumbers;
import static org.assertj.core.api.Assertions.assertThat;

public class RaceControllerTest {

    private final RaceOutputView outputView = new RaceOutputView();

    @Test
    @DisplayName("OK : 자동차 레이싱 플레이")
    void testRace_winners() throws IOException {
        RaceController raceController = new RaceController(outputView, new FakeRandom(winnersNumbers));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("neo,brie,brown\n5\n".getBytes());
        System.setIn(byteArrayInputStream);

        raceController.start();

        String output = outputStream.toString();
        assertThat(output).contains("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        assertThat(output).contains("시도할 회수는 몇회인가요?");
        assertThat(output).contains("실행 결과");
        assertThat(output).contains("neo : -");
        assertThat(output).contains("neo : --");
        assertThat(output).contains("neo : ---");
        assertThat(output).contains("neo : ----");
        assertThat(output).contains("neo : -----");
        assertThat(output).contains("brie : -");
        assertThat(output).contains("brie : --");
        assertThat(output).contains("brie : ---");
        assertThat(output).contains("brie : ----");
        assertThat(output).contains("brown : -");
        assertThat(output).contains("brown : --");
        assertThat(output).contains("brown : ---");
        assertThat(output).contains("brown : ----");
        assertThat(output).contains("brown : -----");
        assertThat(output).contains("neo, brown가 최종 우승했습니다.");
        byteArrayInputStream.close();
    }
}
