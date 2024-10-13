public class Car {

  private int coordinateX;
  private final String name;
  private final NumberGenerator numberGenerator;

  public static Car makeCar(String name) {
    return new Car(new RandomNumberGenerator(), 0, name);
  }

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
