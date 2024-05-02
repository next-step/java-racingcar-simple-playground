package model;

import utils.RandomNumberGenerator;

public class Car {

  private final String name;
  private int score;
  private int randomNumber;

  public Car(final String name) {
    validateCarName(name);
    this.name = name;
  }

  public Car(final String name, final int score) {
    this.name = name;
    this.score = score;
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
    this.randomNumber = RandomNumberGenerator.generate();
    if (randomNumber > 3) {
      score += 1;
    }
  }

  public int getRandomNumber() {
    return randomNumber;
  }
}
