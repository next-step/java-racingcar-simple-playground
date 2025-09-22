package controller;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import utils.RandomDigitGenerator;
import view.RaceInputView;
import view.RaceOutputView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

class RaceControllerTest {

    @Test
    void getValidCarNames_carNames를_입력받는_경우() {
        // given
        RaceInputView raceInputView = mock(RaceInputView.class);
        RaceOutputView raceOutputView = mock(RaceOutputView.class);
        RandomDigitGenerator randomDigitGenerator = mock(RandomDigitGenerator.class);

        when(raceInputView.getCarNames())
                .thenReturn(List.of())
                .thenReturn(List.of("a", "b1"))
                .thenReturn(List.of("a", "b"));

        RaceController controller = new RaceController(raceInputView, raceOutputView, randomDigitGenerator);

        // when
        List<String> result = controller.getValidCarNames();

        // then
        InOrder io = inOrder(raceOutputView, raceInputView);
        io.verify(raceOutputView).printGetCarNameMessage();
        io.verify(raceInputView).getCarNames();
        verify(raceOutputView, times(1)).printEmptyNameExceptionMessage();

        io.verify(raceOutputView).printGetCarNameMessage();
        io.verify(raceInputView).getCarNames();
        verify(raceOutputView, times(1)).printInvalidNameLanguageExceptionMessage();

        io.verify(raceOutputView).printGetCarNameMessage();
        io.verify(raceInputView).getCarNames();

        assertThat(result).containsExactly("a", "b");
    }

    @Test
    void getValidTurn_raceTurnsInput을_입력받는_경우() {
        // given
        RaceInputView raceInputView = mock(RaceInputView.class);
        RaceOutputView raceOutputView = mock(RaceOutputView.class);
        RandomDigitGenerator randomDigitGenerator = mock(RandomDigitGenerator.class);

        when(raceInputView.getRaceTurnNumber())
                .thenReturn("abc")
                .thenReturn("100000000000000000000")
                .thenReturn("5");

        RaceController controller = new RaceController(raceInputView, raceOutputView, randomDigitGenerator);

        // when
        int turns = controller.getValidTurn();

        // then
        verify(raceOutputView, atLeast(3)).printGetRaceTurnMessage();
        verify(raceOutputView, atLeast(1)).printInvalidTurnExceptionMessage();
        verify(raceOutputView, atLeast(1)).printInvalidIntSizeExceptionMessage();
        assertThat(turns).isEqualTo(5);
    }

    @Test
    void runRace_정상적인_흐름에서_시작부터_종료메시지까지_호출() {
        // given
        RaceInputView raceInputView = mock(RaceInputView.class);
        RaceOutputView raceOutputView = mock(RaceOutputView.class);
        RandomDigitGenerator randomDigitGenerator = mock(RandomDigitGenerator.class);

        when(raceInputView.getCarNames()).thenReturn(List.of("a", "b"));
        when(raceInputView.getRaceTurnNumber()).thenReturn("3");
        when(randomDigitGenerator.generateRandomDigit()).thenReturn(9);

        RaceController controller = new RaceController(raceInputView, raceOutputView, randomDigitGenerator);

        // when
        controller.runRace();

        // then
        verify(raceOutputView).printStartShowResultMessage();
        verify(raceOutputView, times(3)).printRaceOneTurn(anyList());
        verify(raceOutputView).printEndShowResultMessage(anyList());
    }
}
