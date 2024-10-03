import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {
  private final String name;
  private int score = 0;
  private final List<Boolean> results = new ArrayList<>();

  public RacingCar(String name) {
    this.name = name;
  }

  public int move() {
    Random rand = new Random();

    boolean result = rand.nextInt(10) >= 4;

    if (result)
      ++score;

    results.add(result);

    return score;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public String getResultString(int phase) {
    StringBuilder resultString = new StringBuilder();
    for (int i = 0; i < phase && i < results.size(); i++) {
      resultString.append(resultToString(results.get(i)));
    }
    return resultString.toString();
  }

  private String resultToString(Boolean result) {
    if (result)
      return "-";

    return "";
  }
}
