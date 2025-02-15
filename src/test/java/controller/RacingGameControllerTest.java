package controller;


import dto.RaceResultInfoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameControllerTest {

    private static final int BASIC_GAME_COUNT = 10;
    private static final String BASIC_CAR_NAMES = "hello,java,bye,hi";
    private static final char COLON_DELIMITER = ':';

    @Nested
    class race {

        @ParameterizedTest
        @DisplayName("��⸦ �����Ѵ�")
        @CsvSource(
                value = {"a,b,c,d,e", "he,ho,hu"},
                delimiter = COLON_DELIMITER
        )
        void getCarListByNamesAndGameCount(String carNames) {
            RacingGameController racingGameController = new RacingGameController(carNames, BASIC_GAME_COUNT);
            racingGameController.race();
        }

    }

    @Nested
    class getRaceResult {

        @Test
        @DisplayName("���̽��� ����� ������ DTO�� ���� ��ȯ�Ѵ�")
        void getHasLongestMoveDistanceCars() {
            RacingGameController racingGameController = new RacingGameController(BASIC_CAR_NAMES, BASIC_GAME_COUNT);
            racingGameController.race();

            RaceResultInfoDto raceResult = racingGameController.getRaceResult();

            boolean isEmpty = raceResult.getWinnerNames().isEmpty();
            assertThat(isEmpty).isFalse();
        }

    }

}