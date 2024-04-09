package model;

import utils.RandomNumberGenerator;

public class Car {

  private final String name;
  private int score;

  public Car(final String name) {
    validateCarName(name);
    this.name = name;
  }

  private void validateCarName(final String name) {
    if (name.isBlank()) {
      throw new IllegalArgumentException("Car name cannot be blank.");
    }
    
    if (name.length() > 5) {
      throw new IllegalArgumentException("Car name cannot be longer than 5 characters.");
    }
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public void move() {
    if (RandomNumberGenerator.generate() > 3) {
      score += 1;
    }
  }
}
