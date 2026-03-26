package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceTest {

    @Test
    @DisplayName("시도 횟수가 0 이하일 경우 예외가 발생한다.")
    void invalidTrialCount_ThrowsException() {
        Cars cars = new Cars(CarParser.parse("pobi,woni"));
        assertThatThrownBy(() -> new Race(cars, 0, () -> true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("단독 우승자를 정확히 판별하지 못했을 경우 예외를 발생시킨다.")
    void getWinners() {
        Cars cars = new Cars(CarParser.parse("pobi,woni,jun"));

        // 상태를 강제 조작하지 않고, 첫 번째 차례(pobi)에만 전진하도록 전략 통제
        MoveStrategy pobiOnlyStrategy = new MoveStrategy() {
            private int invokeCount = 0;
            @Override
            public boolean isMovable() {
                return invokeCount++ == 0;
            }
        };

        Race race = new Race(cars, 1, pobiOnlyStrategy);
        race.playRound();

        List<String> winners = race.getWinners();
        assertThat(winners).containsExactly("pobi");
    }

    @Test
    @DisplayName("공동 우승자를 정확히 판별하지 못할 경우 예외를 발생시킨다..")
    void getWinners_Multiple() {
        Cars cars = new Cars(CarParser.parse("pobi,woni,jun"));
        // 외부에서 람다로 항상 전진하는 전략 주입
        Race race = new Race(cars, 1, () -> true);

        race.playRound();

        List<String> winners = race.getWinners();
        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni", "jun");
    }
}
