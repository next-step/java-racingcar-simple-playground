package domain;

import lombok.Getter;

@Getter
public class RacingCar {
  private String name;

  public RacingCar(String name) {
    setName(name);
  }

  public int moveByRandom(int random){
    if (random >= 4){
      return 1; //go
    }
    return 0;   //stop
  }

  private void setName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Racing car name cannot be empty");
    }
    this.name = name;
  }
}
