package dao;

import domain.RacingCar;
import dto.RacingCarCreateDto;
import java.util.ArrayList;
import java.util.List;

public class RacingCarDao {
  private final List<RacingCar> racingCars = new ArrayList<>();

  public RacingCar insert(RacingCarCreateDto racingCarCreateDto) {
    RacingCar racingCar = new RacingCar(racingCarCreateDto.getName());
    racingCars.add(racingCar);
    return racingCar;
  }

  public List<RacingCar> select() {
    return racingCars;
  }
}
