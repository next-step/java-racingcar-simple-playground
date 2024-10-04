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

  private int randPower() {
    Random rand = new Random();
    return rand.nextInt(10);
  }

  public int move() {
    return move(randPower());
  }

  public int move(int power) {
    boolean isMovable = checkPower(power);

    if (isMovable)
      ++score;

    results.add(isMovable);

    return score;
  }

  private boolean checkPower(int power) {
    if (power < 0 || power > 9)
      throw new IllegalArgumentException("0~9 사이의 Power 값을 필요로 합니다.");

    return power >= 4;
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
