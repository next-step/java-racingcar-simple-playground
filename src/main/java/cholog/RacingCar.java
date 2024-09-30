public class RacingCar {
  private String name;

  public RacingCar(String name) {
    setName(name);
  }

  public String moveByRandom(int random){
    if (random >= 4){
      return "go";
    }
    return "stop";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Racing car name cannot be empty");
    }
    this.name = name;
  }
}
