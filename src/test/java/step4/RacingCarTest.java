package step4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.controller.RacingCarController;
import step4.domain.RacingGame;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RacingCarTest {


    @ParameterizedTest
    @DisplayName("3개의 이름이 주어졌을시 3개의 Car 객체가 생성된다")
    @CsvSource({"'neo,brie,brown'"})
    void makeThreeCars(String name){
        //given,when
        RacingGame racingGame = new RacingGame(name,5);
        //then
        assertThat(racingGame.getCars()).hasSize(3);
    }

    @ParameterizedTest
    @DisplayName("Race가 끝난후 RacingGame의 tryNo은 0이다")
    @CsvSource({"'neo,brie,brown',5"})
    void makeThreeCars(String name,int tryNo){
        //given
        RacingCarController racingCarController = new RacingCarController(name, tryNo);


        //when
        racingCarController.startRace();
        RacingGame racingGame = racingCarController.getRacingGame();

        //then
        Assertions.assertThat(racingGame.getTryNo()).isEqualTo(0);
    }







}
