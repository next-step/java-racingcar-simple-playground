//package racingcar.domain;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class RacingGameTest {
//    @Test
//    @DisplayName("게임 세팅 시 입력한 이름만큼 자동차 객체가 정상적으로 생성된다")
//    void createGameSetting() {
//        // given
//        List<String> names = List.of("Car1", "Car2", "Car3");
//        int moveTimes = 5;
//
//        // when
//        RacingGameSetting setting = new RacingGameSetting(names, moveTimes);
//
//        // then
//        assertThat(setting.getCarList()).hasSize(3);
//        assertThat(setting.getCarList().get(0).getName()).isEqualTo("Car1");
//        assertThat(setting.getMoveTimes()).isEqualTo(5);
//    }
//
//    @Test
//    @DisplayName("가장 멀리 간 자동차가 단독 우승자로 선정된다")
//    void selectWinnerTest() {
//        // given
//        RacingGameSetting setting = new RacingGameSetting(List.of("Car1", "Car2"), 3);
//
//    }
//
//    @Test
//    @DisplayName("가장 멀리 간 위치가 같은 자동차들은 공동 우승자로 선정된다")
//    void selectWinnersTest() {
//        // given
//        RacingGameSetting setting = new RacingGameSetting(List.of("Car1", "Car2"), 3);
//
//    }
//
//}
