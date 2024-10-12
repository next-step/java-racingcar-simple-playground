import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import converter.RacingCarConverter;
import dao.RacingCarDao;
import dto.RacingCarCreateDto;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import service.RacingCarService;
import service.RacingCarServiceImpl;
import util.NumberGenerateUtil;

public class RacingCarTest {

  @Nested
  @DisplayName("자동차 이동 테스트")
  class RacingCarMoveTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("자동차 이동 조건 테스트")
    void testCondition(int value) {
      NumberGenerateUtil numberGenerateUtil = mock(NumberGenerateUtil.class);
      when(numberGenerateUtil.generateRandomNumber()).thenReturn(value);
      RacingCarDao racingCarDao = new RacingCarDao();
      RacingCarService racingCarService = new RacingCarServiceImpl(racingCarDao, numberGenerateUtil);
      List<RacingCarCreateDto> racingCarCreateDtoList = Stream.of("tester1", "tester2").map(v -> RacingCarConverter.toRacingCarCreateDto("")).toList();
      racingCarService.createRacingCar(racingCarCreateDtoList);

      racingCarService.move();

      int expected = value >= 4 ? 1 : 0;
      int actual = racingCarService.getResults().get(0).getDistance();

      assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    @DisplayName("자동차 이동 조건 예외처리 테스트")
    void moveConditionException(int value) {
      NumberGenerateUtil numberGenerateUtil = mock(NumberGenerateUtil.class);
      when(numberGenerateUtil.generateRandomNumber()).thenReturn(value);
      RacingCarDao racingCarDao = new RacingCarDao();
      RacingCarService racingCarService = new RacingCarServiceImpl(racingCarDao, numberGenerateUtil);
      List<RacingCarCreateDto> racingCarCreateDtoList = Stream.of("tester1", "tester2").map(v -> RacingCarConverter.toRacingCarCreateDto("")).toList();
      racingCarService.createRacingCar(racingCarCreateDtoList);

      assertThatThrownBy(racingCarService::move).isInstanceOf(NumberFormatException.class).hasMessage("0~9 사이의 Power 값을 필요로 합니다.");
    }
  }
}
