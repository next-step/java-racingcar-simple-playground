import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import CarGame2.Car;
import CarGame2.Generator;
import CarGame2.OutputHandler;
import CarGame2.Race;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {

    private Race race;
    private Generator fixedGenerator;

    @BeforeEach
    void setUp() {
        fixedGenerator = new Generator() {
            @Override
            public int generate() {
                return 5;
            }
        };
        race = new Race(List.of("car1", "car2", "car3"), 3, fixedGenerator, new OutputHandler());
    }

    @Test
    @DisplayName("게임 시작 후 모든 자동차가 적어도 한 번 이동")
    void start_이후_자동차_이동_테스트() {
        race.start();
        for (Car car : race.getCars().getCars()) {
            assertThat(car.getPosition()).isGreaterThan(0);
        }
    }

    @Test
    @DisplayName("게임이 올바른 횟수만큼 실행되는지 검증")
    void playRound_호출_횟수_검증() {
        race.start();
        for (Car car : race.getCars().getCars()) {
            assertThat(car.getPosition()).isEqualTo(15);
        }
    }
}
