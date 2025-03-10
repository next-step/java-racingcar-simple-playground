import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class MovingCar{

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String carName=br.readLine();
    Random random = new Random();
    int position=0;

    while(position<30){
      int speed=random.nextInt(10);

      if(speed>4){
        position+=speed;

      }
      System.out.println(carName+"의 현재 위치는 "+position+" 입니다.");

    }

    System.out.println("목적지에 도착했습니다");
  }
}
