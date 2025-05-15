public class Car {

  private final String carName;
  private int position = 0;
  private final RandomMovable randomMovable;

  public Car(String name, RandomMovable randomMovable, int position) {
    this.carName = name;
    this.randomMovable = randomMovable;
    this.position = position;
  }

  public void move() {
    if (randomMovable.canMove()) {
      position++;
    }
  }

  public String getCarName() {
    return carName;
  }

  public int getPosition() {
    return position;
  }

}
