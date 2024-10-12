package service;

import dto.RacingCarCreateDto;
import dto.RacingCarResultDto;
import java.util.List;

public interface RacingCarService {
  void createRacingCar(List<RacingCarCreateDto> racingCarCreateDtoList);

  void move();

  List<RacingCarResultDto> getResults();
}
