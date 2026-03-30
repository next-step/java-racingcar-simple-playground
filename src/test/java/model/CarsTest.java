package model;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarsTest {

    @Test
    void 우승자가_1명일_때_단독_우승자를_정상적으로_반환한다() {
        Cars cars = new Cars(Arrays.asList("pobi", "crong", "honux"));

        NumberGenerator customGenerator = new CustomNumberGenerator(9,2,2);

        // when: 가짜 기계를 넣어서 1턴 진행
        cars.moveAll(customGenerator);
        List<Car> winners = cars.findWinners();

        // then: 혼자 9를 받고 전진한 pobi만 우승해야 함
        assertThat(winners).extracting(Car::getName)
                .containsExactly("pobi");
    }

    @Test
    void 전원_이동_실패_시_전원을_공동_우승자로_정상_반환한다() {
        Cars cars = new Cars(Arrays.asList("pobi", "crong", "honux"));

        NumberGenerator failGenerator = new CustomNumberGenerator(2, 2, 2);

        // when: 가짜 기계를 넣어서 1턴 진행
        cars.moveAll(failGenerator);
        List<Car> winners = cars.findWinners();

        // then: 아무도 전진하지 못했으므로 3명 모두 공동 우승
        assertThat(winners).extracting(Car::getName)
                .containsExactlyInAnyOrder("pobi", "crong", "honux");
    }

    @Test
    void 정상적인_이름_리스트로_Cars_객체가_생성된다() {
        // 정상적인 경우에는 에러가 발생하지 않아야 함을 검증 (assertDoesNotThrow 사용)
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> {
            new Cars(Arrays.asList("pobi", "crong", "honux"));
        });
    }

    @Test
    void 자동차가_2대_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Cars(Arrays.asList("pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 경주는 최소 2대 이상부터 가능합니다.");
    }

    @Test
    void 자동차_이름이_중복되면_예외가_발생한다() {
        // pobi가 두 명 들어갔을 때 에러가 잘 터지는지 확인!
        assertThatThrownBy(() -> new Cars(Arrays.asList("pobi", "pobi", "crong")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 중복될 수 없습니다.");
    }
}
