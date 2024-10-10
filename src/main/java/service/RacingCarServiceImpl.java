package service;

import converter.RacingCarConverter;
import dao.RacingCarDao;
import domain.RacingCar;
import dto.RacingCarCreateDto;
import dto.RacingCarResultDto;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RacingCarServiceImpl implements RacingCarService {
  final RacingCarDao racingCarDao;

  @Override
  public void createRacingCar(final List<RacingCarCreateDto> racingCarCreateDtoList) {
    List<RacingCar> racingCars = racingCarCreateDtoList.stream().map(racingCarDao::insert).toList();
  }

  @Override
  public void move() {
    for (RacingCar racingCar : racingCarDao.select()){
      Random rand = new Random();

      boolean result = rand.nextInt(10) >= 4;

      racingCar.getResults().add(result);
    }
  }

  @Override
  public List<RacingCarResultDto> getResults() {
    return racingCarDao.select().stream().map(RacingCarConverter::toRacingCarResultDto).toList();
  }
}
