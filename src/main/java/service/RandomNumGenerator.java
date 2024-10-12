package service;

import java.util.Random;

public class RandomNumGenerator implements NumGenerator {

  private final int RAND_MAX = 10;
  private final int RAND_MIN  = 0;

  @Override
  public int createNumber() {
    Random random = new Random();
    return random.nextInt(0, 10);
  }



}
