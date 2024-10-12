package model;

import Dto.GameResultDto;
import Dto.RoundResultDto;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {

  private int maxPos = 0;

  private final List<Car> carList = new ArrayList<>();


  public void createCarList(List<String> nameList) {
    for (String name : nameList) {
      carList.add(new Car(name));
    }
  }

  private void getMaxPos() {
    int maxPos = 0;
    for (Car car : carList) {
      maxPos = Math.max( maxPos, car.getPos() );
    }

    this.maxPos = maxPos;
  }

  private boolean isWinner(Car car) {
    if (maxPos == car.getPos()) {
      return true;
    }
    else {
      return false;
    }
  }

  public void run() {
    for (Car car : carList) {
      car.move();
    }
  }

  public GameResultDto getWinnerList() {
    List<String> winnerList = new ArrayList<>();

    getMaxPos();

    winnerList = carList.stream()
        .filter( car -> isWinner(car) )
        .map(Car::getName)
        .toList();

    return new GameResultDto().builder()
        .name(winnerList)
        .build();
  }

  public List<Car> getCarList() {
    return carList;
  }

  public List<RoundResultDto> getRoundResult() {

    List<RoundResultDto> roundResultDtoList = new ArrayList<>();

    for(Car car : carList){
      RoundResultDto roundResultDto = new RoundResultDto().builder()
          .name(car.getName())
          .pos(car.getPos())
          .build();

      roundResultDtoList.add(roundResultDto);
    }

    return roundResultDtoList;
  }

}
