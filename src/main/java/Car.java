public class Car {

  int coordinateX;
  String name;

  public Car(int coordinateX, String name) {
    this.coordinateX = coordinateX;
    this.name = name;
  }

  /**
   *
   * @param randomNumber 랜덤 숫자
   */
  public void move(int randomNumber) {
    if (randomNumber < 0 || randomNumber > 9) {
      throw new IllegalArgumentException("랜덤 숫자가 0과 9 범위 사이가 아닙니다.");
    }
    if (randomNumber >= 4) {
      this.coordinateX += 1;
    }
  }
}
