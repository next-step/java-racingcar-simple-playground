package Model;

import Creator.ForTestNumberCreator;
import Creator.NumberCreator;
import Model.RacingGame;
import Utils.StringToCar;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class RacingGameTest {

    @DisplayName("레이스가 잘 되어야함.")
    @Test
    void race_test(){
        NumberCreator forTestNumberCreator = new ForTestNumberCreator(Arrays.asList(0, 5, 5));
        StringToCar stringToCar = new StringToCar(Arrays.asList("jue", "byung", "ju"));
        RacingGame racingGame = new RacingGame(stringToCar.getCarList(),1,forTestNumberCreator);
        racingGame.race();
        Assertions.assertThat(racingGame.getCarList())
                .extracting("position")
                .containsExactly(0,1,1);
    }


    @DisplayName("위너를 잘 출력해야 함.")
    @Test
    void is_right_winner(){
        NumberCreator forTestNumberCreator = new ForTestNumberCreator(Arrays.asList(0, 5, 5));
        StringToCar stringToCar = new StringToCar(Arrays.asList("jue", "byung", "ju"));
        RacingGame racingGame = new RacingGame(stringToCar.getCarList(),1,forTestNumberCreator);
        racingGame.race();
        Assertions.assertThat(racingGame.getWinners())
                .containsExactly("byung","ju");
    }

}
