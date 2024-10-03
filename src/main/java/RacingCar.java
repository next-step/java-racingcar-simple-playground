class RacingCar {
  public String name;
  public int distance;

  public RacingCar(String name) {
    this.name = name;
    this.distance = 0;
  }

  public void move() {
    if(( (int) (Math.random() * 10) >= 4))
      distance += 1;
  }
}