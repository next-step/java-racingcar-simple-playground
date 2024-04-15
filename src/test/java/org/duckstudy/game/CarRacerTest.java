package org.duckstudy.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.doAnswer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.duckstudy.movingcar.Car;
import org.duckstudy.movingcar.CarMover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@DisplayName("자동차 게임 테스트")
class CarRacerTest {

    @InjectMocks
    private CarRacer carRacer;
    @Mock
    private CarMover carMover;

    private String[] nameList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("게임 종료 시 우승자를 반환한다")
    void calculateWinnerWhenGameEnds() {
        nameList = new String[]{"Car1", "Car2", "Car3"};
        carRacer = new CarRacer(carMover, 3, 5, nameList);
        doAnswer(invocation -> {
            List<Car> carList = invocation.getArgumentAt(0, List.class);
            carList.stream().filter(c -> c.getName().equals(nameList[0]) || c.getName().equals(nameList[1]))
                    .forEach(Car::move);
            return null;
        }).when(carMover).move(anyListOf(Car.class));

        ArrayList<Car> winnerList = carRacer.play();

        assertThat(winnerList.size()).isEqualTo(2);
        assertThat(winnerList.get(0).getName()).isEqualTo(nameList[0]);
        assertThat(winnerList.get(1).getName()).isEqualTo(nameList[1]);
    }

    @Test
    @DisplayName("하나 이상의 자동차 이름이 5글자 초과일 때 에러를 발생한다.")
    void gameFailWhenCarNameLengthIsOver5() {
        nameList = new String[]{"abcdef", "ghk"};

        assertThatThrownBy(() -> new CarRacer(carMover, 2, 5, nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @ParameterizedTest
    @MethodSource("methodSourceRepetitionNumTestArguments")
    @DisplayName("반복 횟수가 0 이하일때 에러를 발생한다.")
    void gameFailWhenRepetitionNumIsEqualOrLessThan0(int repetitionNum) {
        nameList = new String[]{"abc", "def"};

        assertThatThrownBy(() -> new CarRacer(carMover, 2, repetitionNum, nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 0보다 커야 합니다.");
    }

    private static Stream<Arguments> methodSourceRepetitionNumTestArguments() {
        return Stream.of(
                Arguments.arguments(0),
                Arguments.arguments(-1)
        );
    }
}
