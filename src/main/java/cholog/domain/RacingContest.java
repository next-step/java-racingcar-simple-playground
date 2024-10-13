package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import lombok.Getter;

@Getter
public class RacingContest {
  private static final Random random = new Random();
  private final List<RacingCar> racingCars;
  private final Map<String, Integer> distances;
  private final int rounds;

  public RacingContest(List<String> playerNames, int rounds) {
    this.racingCars = playerNames.stream().map(RacingCar::new).toList();
    this.distances = new HashMap<>();
    for (RacingCar car : racingCars){
      distances.putIfAbsent(car.getName(), 0);
    }
    this.rounds = rounds;
  }

  public void goRound(){
    for (RacingCar car : racingCars) {
      String name = car.getName();
      int move = car.moveByRandom(random.nextInt(10));
      distances.compute(name, (k, v) -> v + move);
    }
  }

  public List<String> getWinners() {
    List<String> winners = new ArrayList<>();
    int max = distances.values().stream().max(Integer::compareTo).get();
    distances.entrySet().stream()
        .filter(e -> e.getValue() >= max)
        .forEach(e -> winners.add(e.getKey()));

    return winners;
  }
}
