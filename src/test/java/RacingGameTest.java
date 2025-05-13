import domain.RacingCar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RacingGameTest {

    @Test
    @DisplayName("자동차 이름이 5자 이하면 생성에 성공한다")
    void carNameCheckUp() {
        assertThatCode(() -> new RacingCar("지두"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과면 예외 처리")
    void carNameCheckDown() {
        assertThatThrownBy(() -> new RacingCar("지두지두지두"))   // assertThatThrownBy 예외 처리 함수
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차");    // 자동차 이름은 5자 이하여야 합니다 라고 출력해서
                                                            // hasMessageContaining("자동차") 라고 작성했는데 예외 처리가 잘 된건지 모르겠어요
    }

    @Test
    @DisplayName("우승 자동차 찾기")
    void findWinner() {
        // 시드 고정 -> 동일한 난수 시퀀스 생성
        RandomNumber randomNumber = new RandomNumber(42);

        RacingCar car1 = new RacingCar("붕붕이");
        RacingCar car2 = new RacingCar("방방이");
        RacingCar car3 = new RacingCar("탕탕이");

        List<RacingCar> cars = List.of(car1, car2, car3);
        int testRound = 5;

        IntStream.range(0, testRound).forEach(i ->
                cars.stream().forEach(car -> {
                    boolean canMove = car.racingCarStatus();
                    int number = 3;
                    if (canMove) number = 5;
                    car.move(number);
                })
        );


        int maxPosition = cars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);

        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(RacingCar::getCarName)
                .toList();

        assertThat(winners.size()).isEqualTo(3);
        assertThat(winners).containsExactlyInAnyOrder("붕붕이", "방방이", "탕탕이");
    }

    @Test
    @DisplayName("난수가 4이상이면 전진")
    void carRun() {
        RacingCar car = new RacingCar("aaa");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("난수가 3이하면 정지")
    void carStop() {
        RacingCar car = new RacingCar("aaa");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}