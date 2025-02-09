import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차 경주 테스트")
public class TestRace {

    @Nested
    @DisplayName("자동차 경주 기능 테스트")
    class TestRaceFeatures{

        @Test
        @DisplayName("우승 자동차 구하기 테스트")
        void testRace(){
            //given
            final Race testRace = new Race("test1,test2,test3");

            //when
            //5회 동안 경주
            testRace.runRace(5);

            //then
            assertThat(testRace.getWinner().get(0)).isNotNull();
        }
    }
}
