package org.duckstudy.model.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import org.duckstudy.model.generator.Generator;
import org.duckstudy.model.generator.RandomValueGenerator;
import org.duckstudy.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 경주 테스트")
class CarsTest {

    private final Generator generator = new RandomValueGenerator();
    private final OutputView outputView = new OutputView();
    private final Cars cars = mock(Cars.class);

    @Test
    @DisplayName("경주가 완료되면 우승자를 계산한다")
    void calculateWinnerWhenRaceIsOver() {
        String[] carNames = new String[]{"Car1", "Car2", "Car3"};
        String[] selectedWinnerNames = Arrays.copyOfRange(carNames, 0, 2);
        Cars selectedWinners = new Cars(selectedWinnerNames, generator);
        doReturn(selectedWinners).when(cars).playAndGetWinners(anyInt(), any(OutputView.class));

        Cars winners = cars.playAndGetWinners(5, outputView);

        assertAll(
                () -> assertThat(winners.getCars().size()).isEqualTo(selectedWinnerNames.length),
                () -> assertThat(winners.getCars().get(0).getName()).isEqualTo(selectedWinnerNames[0]),
                () -> assertThat(winners.getCars().get(1).getName()).isEqualTo(selectedWinnerNames[1])
        );
    }
}
