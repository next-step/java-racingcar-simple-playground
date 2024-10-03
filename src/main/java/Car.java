import java.util.Comparator;
import java.util.Random;
import javax.management.RuntimeErrorException;

public class Car{

  public int pos=0;
  public int carId;
  public int rank;
  private int RAND_MAX = 9;


  public Car(int Id) {
    this.pos = 0;
    this.carId = Id;
  }

  public void move() {
    int rand = getRandNum();
    go(rand);
  }

  public void go(int num) {
      if (num < 3) {
        pos +=1;
        return;
      }
      if (num < 9) {
        return;
      }
      throw new RuntimeException("예상치 못한 랜덤값 입력");
  }

  public int getRandNum() {
    Random random = new Random();
    int randNum = random.nextInt(RAND_MAX);
    return randNum;
  }
}
