import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CarRunner {
  private static int DESTINATION;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String carName=getCarName(br);
    DESTINATION=getDestination(br);
    Car car=new Car(carName);

    runSimulation(car);
  }

  private static String getCarName(BufferedReader br) throws IOException {
    System.out.print("자동차 이름을 입력하세요: ");
    return br.readLine();
  }

  private static int getDestination(BufferedReader br) throws IOException {
    System.out.print("목적지의 거리를 입력하세요: ");
    return Integer.parseInt(br.readLine());
  }

  private static void runSimulation(Car car){
    while(car.getPosition()<DESTINATION){
      car.move();
      System.out.println(car.getName()+"의 현재 위치: "+ car.getPosition());
    }
    System.out.println(car.getName()+"가 목적지에 도달했습니다! (최종 위치: "+car.getPosition()+")");
  }
}
