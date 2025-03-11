public class Car {
  private final String name;
  private int position;

  public Car(String name){
    this.name = name;
    this.position = 0;
  }

  public void move(){
    int speed=generateSpeed();
    updatePosition(speed);
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

  public String getName() {
    return name;
  }
}
