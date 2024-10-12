public class Car {

  private int coordinateX;
  private final String name;
  private final NumberGenerator numberGenerator;

  public Car(NumberGenerator numberGenerator, int coordinateX, String name) {
    this.numberGenerator = numberGenerator;
    this.coordinateX = coordinateX;
    this.name = name;
  }

  public void move() {
    int randomNumber = this.numberGenerator.getNumber();

    if (randomNumber >= 4) {
      this.coordinateX += 1;
    }
  }

  public String getName() {
    return name;
  }

  public int getCoordinateX() {
    return coordinateX;
  }
}
