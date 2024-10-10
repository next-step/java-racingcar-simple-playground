public class Car {

  private final NumberGenerator numberGenerator;
  private final String name;
  private int position;

  public Car(final String name, final NumberGenerator numberGenerator) {
    this.name = name;
    this.numberGenerator = numberGenerator;
    this.position = 0;
  }

  public Car(final String name, final int position) {
    this.name = name;
    this.position = position;
    this.numberGenerator = new RandomNumberGenerator();
  }

  public Car(final String name) {
    this.name = name;
    this.numberGenerator = new RandomNumberGenerator();
    this.position = 0;
  }


  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }

  public void move() {
    if (numberGenerator.getNumber() >= 4) {
      position ++;
    }
  }
}
