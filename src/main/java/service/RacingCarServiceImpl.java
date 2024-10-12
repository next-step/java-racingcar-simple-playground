package service;

import converter.RacingCarConverter;
import dao.RacingCarDao;
import domain.RacingCar;
import dto.RacingCarCreateDto;
import dto.RacingCarResultDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import util.NumberGenerateUtil;

@RequiredArgsConstructor
public class RacingCarServiceImpl implements RacingCarService {
  final RacingCarDao racingCarDao;
  final NumberGenerateUtil numberGenerateUtil;

  @Override
  public void createRacingCar(final List<RacingCarCreateDto> racingCarCreateDtoList) {
    List<RacingCar> racingCars = racingCarCreateDtoList.stream().map(racingCarDao::insert).toList();
  }

  @Override
  public void move() {
    for (RacingCar racingCar : racingCarDao.select()){
      int power = numberGenerateUtil.generateRandomNumber();

      if (0 <= power && power <= 9)
        racingCar.getResults().add(power >= 4);
      else
        throw new NumberFormatException("0~9 사이의 Power 값을 필요로 합니다.");
    }
  }

  @Override
  public List<RacingCarResultDto> getResults() {
    return racingCarDao.select().stream().map(RacingCarConverter::toRacingCarResultDto).toList();
  }
}
