package Model;

import Creator.ForTestNumberCreator;
import Creator.NumberCreator;
import Utils.StringToCar;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class WinnerTest {

    @DisplayName("이동거리의 맥스값을 잘 뽑아야함.")
    @Test
    void is_right_max(){
        NumberCreator forTestNumberCreator = new ForTestNumberCreator(Arrays.asList(0, 5, 5));
        StringToCar stringToCar = new StringToCar(Arrays.asList("jue", "byung", "ju"));
        RacingGame racingGame = new RacingGame(stringToCar.getCarList(),1,forTestNumberCreator);
        racingGame.race();
        Assertions.assertThat(Winner.findMaxCount(racingGame.getCarList()))
                .isEqualTo(1);
    }

    @DisplayName("맥스값을 가지고 있는 자동차 리스트를 뽑아야함.")
    @Test
    void is_right_carList(){
        NumberCreator forTestNumberCreator = new ForTestNumberCreator(Arrays.asList(0, 5, 5));
        StringToCar stringToCar = new StringToCar(Arrays.asList("jue", "byung", "ju"));
        RacingGame racingGame = new RacingGame(stringToCar.getCarList(),1,forTestNumberCreator);
        racingGame.race();
        Assertions.assertThat(Winner.findWinner(racingGame.getCarList()))
                .containsExactly("byung","ju");
    }
}
