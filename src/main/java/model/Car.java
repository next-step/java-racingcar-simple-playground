package model;

import service.NumGenerator;
import service.RandomNumGenerator;


public class Car {
  private int pos=0;
  private String name;
  private NumGenerator numGenerator = new RandomNumGenerator();

  public int getPos() {
    return this.pos;
  }

  public void setPos(int pos) {
    this.pos = pos;
  }

  public String getName() {
    return this.name;
  }

  public Car (String name) {
    numGenerator = new RandomNumGenerator();
    this.name = name;
  }

  public Car (String name, NumGenerator numGenerator) {
    this.numGenerator = numGenerator;
    this.name = name;
  }

  public void move() {
    int num = numGenerator.createNumber();
    if (num > 9 || num < 0) {
      throw new RuntimeException("생성된 숫자가 정해진 범위를 초과합니다.");
    }

    else if (num >= 4) {
        pos += 1;
    }
  }

}
