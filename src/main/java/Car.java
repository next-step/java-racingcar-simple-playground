public class Car {

  private int position;
  private final CarName name;
  private int speed;

  public Car(String name) {
    this.position = 0;
    this.name = new CarName(name);
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
    if (speed >= 4) {
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
