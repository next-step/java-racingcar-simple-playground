package service;

public class FixedNumGenerator implements NumGenerator{

  private int num;

  public FixedNumGenerator (final int num) {
    this.num = num;
  }
  @Override
  public int createNumber() {
    return num;
  }
}
