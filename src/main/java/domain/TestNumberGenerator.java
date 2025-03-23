package domain;

public class TestNumberGenerator implements NumberGenerator {

  private final int[] speeds;
  private int index;

  public TestNumberGenerator(int[] speeds) {
    this.speeds = speeds;
    this.index = 0;
  }

  @Override
  public int generate() {
    if (index >= speeds.length) {
      return 0;
    }
    return speeds[index++];
  }
}
