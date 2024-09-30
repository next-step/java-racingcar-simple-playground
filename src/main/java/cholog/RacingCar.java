public class RacingCar {
  private String name;

  public RacingCar(String name) {
    this.name = name;
  }

  public void moveByRandom(){
    int random = (int) (Math.random() * 10);
    if (random >= 4){
      go();
    }
    if (random < 4){
      stop();
    }
  }

  public void go(){
    System.out.println(name + " goes forward");
  }

  public void stop(){
    System.out.println(name + " stops");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
