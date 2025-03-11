import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RaceInput {
  private static BufferedReader br;

  public static List<Car> getCars()throws IOException{
    br= new BufferedReader(new InputStreamReader(System.in));
    int carCount=getCarCount();
    List<Car> cars = new ArrayList<>();

    for(int i=1;i<=carCount;i++){
      cars.add(new Car(i));
    }
    return cars;
  }

  private static int getCarCount() throws IOException {
    System.out.print("자동차 대수를 입력하세요: ");
    return Integer.parseInt(br.readLine());
  }

  public static int getAttempts() throws IOException {
    System.out.print("시도 횟수를 입력하세요: ");
    return Integer.parseInt(br.readLine());
  }
}
