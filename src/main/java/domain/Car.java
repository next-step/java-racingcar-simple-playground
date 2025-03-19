package domain;

public class Car {

  private int position;
  private final CarName name;
  private final NumberGenerator numberGenerator;
  private int speed;
  private static final int MOVABLE_MINIMUM_SPEED = 4;

  public Car(String name, NumberGenerator numberGenerator) {
    this.position = 0;
    this.name = CarName.of(name);
    this.numberGenerator = numberGenerator;
    this.speed = 0;
  }

  public void move() {
    speed = numberGenerator.generate();
    updatePosition(speed);
  }

  private void updatePosition(int speed) {
    if (speed >= MOVABLE_MINIMUM_SPEED) {
      position++;
    }
  }

  public void moveWithSpeed(int speed) {
    this.speed = speed;
    updatePosition(speed);
  }

  public int getLastSpeed() {
    return speed;
  }

  public int getPosition() {
    return position;
  }

  public String getName() {
    return name.getName();
  }
}
