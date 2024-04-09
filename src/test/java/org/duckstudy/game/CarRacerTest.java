package org.duckstudy.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.doAnswer;

import java.util.ArrayList;
import java.util.List;
import org.duckstudy.movingcar.Car;
import org.duckstudy.movingcar.CarMover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@DisplayName("자동차 게임 테스트")
class CarRacerTest {

    @Mock
    private CarMover carMover;

    @InjectMocks
    private CarRacer carRacer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        carRacer = new CarRacer(carMover, 5, 3);
    }

    @Test
    @DisplayName("게임 종료 시 우승자를 반환한다")
    void calculateWinnerWhenGameEnds() {
        doAnswer(invocation -> {
            List<Car> carList = invocation.getArgumentAt(0, List.class);
            for (Car c : carList) {
                if (c.getName().equals("1번째 자동차") || c.getName().equals("2번째 자동차")) {
                    c.move();
                }
            }
            return null;
        }).when(carMover).move(anyListOf(Car.class));

        ArrayList<Car> winnerList = carRacer.play();

        assertThat(winnerList.size()).isEqualTo(2);
        assertThat(winnerList.get(0).getName()).isEqualTo("1번째 자동차");
        assertThat(winnerList.get(1).getName()).isEqualTo("2번째 자동차");
    }

}
