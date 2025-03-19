package domain;

public class FixedNumberGenerator implements NumberGenerator {

  private final int fixedSpeed;

  public FixedNumberGenerator(int fixedSpeed) {
    this.fixedSpeed = fixedSpeed;
  }

  @Override
  public int generate() {
    return fixedSpeed;
  }
}
