package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

public class WinnerFinderTest {

    @Test
    void 가장_멀리_간_자동차_우승() {
        Car seoyeon = new Car("seoyeon"); // 자동차 세 대 생성
        Car minsu = new Car("minsu");
        Car jisu = new Car("jisu");

        moveThreeTimes(seoyeon); // 자동차 세 번 전진
        moveTwoTimes(minsu); // 두 번
        moveOneTime(jisu); // 한 번

        WinnerFinder winnerFinder = new WinnerFinder(); // 우승자 찾아주는 객체 생성
        List<String> winners = winnerFinder.findWinners(List.of(seoyeon, minsu, jisu));
        // 자동차 세 대를 하나의 목록으로 만들어 전달> 결과로 반환된 우승자 이름 목록 winners에 저장

        assertThat(winners).containsExactly("seoyeon"); // 우승자 목록에 한 명만 들어 있는지 검사
    }

    @Test
    void 위치_같을시_공동_우승() {
        Car seoyeon = new Car("seoyeon");
        Car minsu = new Car("minsu");
        Car jisu = new Car("jisu");

        moveTwoTimes(seoyeon);
        moveTwoTimes(minsu);
        moveOneTime(jisu);

        WinnerFinder winnerFinder = new WinnerFinder();
        List<String> winners = winnerFinder.findWinners(List.of(seoyeon, minsu, jisu));

        assertThat(winners)
                .containsExactly("seoyeon", "minsu");
    }

    private void moveThreeTimes(Car car) { // 전달받은 자동차 세 번 전진
        car.move(4); // 전진 조건 만족> 호출할 때마다 위치 1씩 증가
        car.move(4);
        car.move(4);
    }

    private void moveTwoTimes(Car car) { // 두 번
        car.move(4);
        car.move(4);
    }

    private void moveOneTime(Car car) {
        car.move(4);
    }
}