import static org.assertj.core.api.Assertions.assertThat;

import converter.RacingCarConverter;
import domain.RacingCar;
import dto.RacingCarCreateDto;
import dto.RacingCarResultDto;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarConverterTest {

  @Test
  public void testToRacingCarCreateDto() {
    RacingCarCreateDto expected = new RacingCarCreateDto("tester");
    RacingCarCreateDto actual = RacingCarConverter.toRacingCarCreateDto("tester");
    assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  public void testToRacingCarResultDto() {
    RacingCarResultDto expected = new RacingCarResultDto("tester", "---", 3);
    RacingCar racingCar = new RacingCar("tester");
    racingCar.getResults().addAll(List.of(false, false, true, true, true));
    RacingCarResultDto actual = RacingCarConverter.toRacingCarResultDto(racingCar);
    assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
  }

  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  public void testResultToString(boolean value) {
    String expected = value ? "-" : "";
    String actual = RacingCarConverter.resultToString(value);

    assertThat(actual).isEqualTo(expected);
  }
}
