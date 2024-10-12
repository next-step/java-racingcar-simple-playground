public class TestNumberGenerator implements NumberGenerator{

  private final int setNumber;

  public TestNumberGenerator(int number) {
    this.setNumber = number;
  }

  @Override
  public int getNumber() {
    return this.setNumber;
  }
}
