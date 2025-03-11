public class Car {
  private int position;
  private int index;

  public Car(int index){
    this.position = 0;
    this.index = index;
  }

  public int move() {
    int speed = generateSpeed();
    updatePosition(speed);
    return speed;
  }

  private void updatePosition(int speed) {
    if (speed >= 4) {
      position += speed;
    }
  }

  private int generateSpeed() {
    return (int) (Math.random() * 10);
  }

  public int getPosition() {
    return position;
  }

  public int getIndex() {
    return index;
  }
}
