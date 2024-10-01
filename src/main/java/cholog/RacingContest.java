import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import lombok.Getter;

@Getter
public class RacingContest {
  private static final Random random = new Random();
  private final RacingCar[] RACING_CARS;
  private final int rounds;

  public RacingContest(RacingCar[] racingCars, int racingRounds) {
    RACING_CARS = racingCars;
    rounds = racingRounds;
  }

  public int[] start(){
    int[] distances = new int[RACING_CARS.length];

    for (int r = 0; r < rounds; r++) {
      for (int c = 0; c < RACING_CARS.length; c++) {
        distances[c] += RACING_CARS[c].moveByRandom(random.nextInt(10));
      }
    }

    return distances;
  }

  public ArrayList<String> ranking(int[] distances){
    int maxDist = Arrays.stream(distances).max().getAsInt();    // winner decision
    ArrayList<String> winners = new ArrayList<>();

    for (int i = 0; i < distances.length; i++) {
      if (distances[i] == maxDist) {
        winners.add(RACING_CARS[i].getName());
      }
    }

    return winners;
  }
}
