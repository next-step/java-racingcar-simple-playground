import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("우승 자동차 구하기 테스트")
class RaceTest {
    // 항상 전진하는 moveRandom 객체 생성
    private static final Random moveRandom = new Random() {
        @Override
        public int nextInt(int bound) {
            return 4;
        }
    };
    // 항상 정지하는 stopRandom 객체 생성
    private static final Random stopRandom = new Random() {
        @Override
        public int nextInt(int bound) {
            return 3;
        }
    };
    private RacingCar carA;
    private RacingCar carB;
    private Race race;

    @BeforeEach
    void setup() {
        // CarA는 매 라운드마다 전진하고, CarB는 매 라운드마다 정지함
        carA = new RacingCar("CarA", moveRandom);
        carB = new RacingCar("CarB", stopRandom);
        race = new Race(List.of(carA, carB));
    }

    @DisplayName("race()가 라운드 수만큼 자동차를 전진/정지 시키는가?")
    @Test
    void checkCarsMoveCountAfterRace() {
        race.race(5);

        assertThat(carA.getPosition())
                .as("CarA가 5번의 라운드 동안 5번 전진해야 합니다.")
                .isEqualTo(5);

        assertThat(carB.getPosition())
                .as("CarB가 5번의 라운드 동안 5번 정지해야 합니다.")
                .isEqualTo(0);
    }

    @DisplayName("findWinners() 메서드가 올바른 우승자를 반환하는가?")
    @Test
    void verifyCorrectWinners() {
        race.race(5);
        List<RacingCar> winners = race.findWinners();

        assertThat(winners)
                .hasSize(1)
                .extracting(RacingCar::getName)
                .containsExactly("CarA");
    }

    @DisplayName("동점인 경우, 우승자가 여러 명이 나오는가?")
    @Test
    void checkMultipleWinners() {
        // CarB도 항상 전진하도록 설정 (동점 상황)
        carB = new RacingCar("CarB", moveRandom);
        race = new Race(List.of(carA, carB));

        race.race(5);
        List<RacingCar> winners = race.findWinners();

        assertThat(winners)
                .hasSize(2)
                .extracting(RacingCar::getName)
                .containsExactly("CarA", "CarB");
    }
}
