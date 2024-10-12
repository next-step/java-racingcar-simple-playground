public class RacingCar {

  private final String name;
  private int distance;

  public RacingCar(String name) {
    this.name = name;
    this.distance = 0;
  }

  public String getName() {
    return name;
  }

  public int getDistance() {
    return distance;
  }

  public void move() {
    if(( (int) (Math.random() * 10) >= 4))
      distance += 1;
  }
}