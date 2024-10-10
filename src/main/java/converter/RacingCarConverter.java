package converter;

import domain.RacingCar;
import dto.RacingCarCreateDto;
import dto.RacingCarResultDto;
import java.util.stream.Collectors;

public class RacingCarConverter {
  public static RacingCarCreateDto toRacingCarCreateDto(String name) {
    return RacingCarCreateDto.builder().name(name).build();
  }

  public static RacingCarResultDto toRacingCarResultDto(RacingCar racingCar) {
    return RacingCarResultDto.builder().
        name(racingCar.getName())
        .resultString(racingCar.getResults().stream().map(RacingCarConverter::resultToString).collect(
            Collectors.joining()))
        .distance((int) racingCar.getResults().stream().filter(v -> v).count()).build();
  }

  public static String resultToString(Boolean result) {
    if (result)
      return "-";

    return "";
  }
}
