package domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarRaceTest {
    @DisplayName("자동차가 랜덤값이 3이하면 움직이지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testDetermineMoveDistance3Down(int value) {
        //given
        CarRace carrace = new CarRace();
        //when
        int result = carrace.determineMoveDistance(value);
        //then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("자동차가 랜덤값이 4이상이면 움직인다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void testDetermineMoveDistance4Up(int value) {
        //given
        CarRace carrace = new CarRace();
        //when
        int result = carrace.determineMoveDistance(value);
        //then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("적절한 범위의 랜덤값을 제공한다.")
    @RepeatedTest(value = 100)
    void testGenerateRandom() {
        //given
        CarRace carrace = new CarRace();
        //when
        int n = carrace.generateRandom0to9();
        boolean result = (n >= 0) && (n <= 9);
        //then
        assertThat(result).isTrue();
    }

    @DisplayName("자동차가 여러대일때 우승자를 구한다.")
    @Test
    void testGetWinner() {
        //given
        CarRace carrace = new CarRace();
        //when
        int[] carsscores = {4, 2, 6, 8, 5};
        String[] carnames = {"CCar1", "CCar2", "CCar3", "CCar4", "CCar5"};
        String maxscorecar = carrace.getWinners(carsscores, carnames);
        //then
        assertThat(maxscorecar).isEqualTo("CCar4");

    }

    @DisplayName("자동차가 여러대일때 우승자가 여러명일때 우승자를 구한다.")
    @Test
    void testGetWinners() {
        //given
        CarRace carrace = new CarRace();
        //when
        int[] carsscores = {4, 2, 8, 8, 5};
        String[] carnames = {"CCar1", "CCar2", "CCar3", "CCar4", "CCar5"};
        String maxscorecar = carrace.getWinners(carsscores, carnames);
        //then
        assertThat(maxscorecar).isEqualTo("CCar3, CCar4");

    }

    @DisplayName("점수에 따라 하이픈 개수가 생성되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "3:---",
            "0:''",
            "5:-----"
    }, delimiter = ':')
    void testGetTrace(int score, String expectedTrace) {
        // given
        CarRace carrace = new CarRace();
        // when
        String actualTrace = carrace.getTrace(score);
        // then
        assertThat(actualTrace).isEqualTo(expectedTrace);
    }

    @DisplayName("자동차 이름이 5자를 초과하면 IllegalArgumentException이 발생한다.")
    @Test
    void testValidateCarName_Failure() {
        //given
        CarRace carrace = new CarRace();
        //when
        String[] invalidNames = {"lalala", "cute"};
        //then
        assertThatThrownBy(() -> carrace.validateCarNames(invalidNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자를 초과할 수 없습니다");
    }

}
