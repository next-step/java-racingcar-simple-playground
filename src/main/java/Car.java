public class Car {

  private int position;
  private final CarName name;
  private int speed;
  private static final int MOVABLE_MINIMUM_SPEED = 4;

  public Car(String name) {
    this.position = 0;
    this.name = CarName.of(name);
    this.speed = 0;
  }

  public void move() {
    this.speed = generateSpeed();
    updatePosition(speed);
  }

  public void moveWithSpeed(int speed) {
    this.speed = speed;
    updatePosition(speed);
  }

  private void updatePosition(int speed) {
    if (speed >= MOVABLE_MINIMUM_SPEED) {
      position += speed;
    }
  }

  public int getLastSpeed() {
    return speed;
  }

  private int generateSpeed() {
    return (int) (Math.random() * 10);
  }

  public int getPosition() {
    return position;
  }

  public String getName() {
    return name.getName();
  }
}
