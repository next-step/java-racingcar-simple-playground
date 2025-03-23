import static org.assertj.core.api.Assertions.assertThat;

import CarGame2.domain.model.Car;
import CarGame2.domain.model.Race;
import CarGame2.domain.service.FixedGenerator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {

    private Race race;

    @BeforeEach
    void setUp() {
        FixedGenerator fixedGenerator = new FixedGenerator(5);
        race = new Race(List.of("car1", "car2", "car3"), 3, fixedGenerator);
    }

    @Test
    @DisplayName("게임 시작 후 모든 자동차가 적어도 한 번 이동")
    void start_이후_자동차_이동_테스트() {
        race.playRound();
        for (Car car : race.getCars().getCars()) {
            assertThat(car.getPosition()).isGreaterThan(0);
        }
    }

    @Test
    @DisplayName("게임이 올바른 횟수만큼 실행되는지 테스트")
    void playRound_호출_횟수_확인() {
        for (int i = 0; i < race.getRounds(); i++) {
            race.playRound();
        }
        for (Car car : race.getCars().getCars()) {
            assertThat(car.getPosition()).isEqualTo(15);
        }
    }

    @Test
    @DisplayName("게임 종료 후 우승자가 정상적으로 판별되는지 테스트")
    void 우승자_판별_테스트() {
        for (int i = 0; i < race.getRounds(); i++) {
            race.playRound();
        }
        List<String> winners = race.getWinners();
        assertThat(winners).containsExactlyInAnyOrder("car1", "car2", "car3");
    }
}
