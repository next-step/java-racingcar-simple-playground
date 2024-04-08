import java.util.Scanner;
import java.util.Random;
public class RacingCarStep1 {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    String carName ;
    int location = 0 ;

    // 자동차의 이름을 받아주는 함수
    public void getCarName(){
        carName = scanner.nextLine();
    }

    // 랜덤으로 나온 값에 대해 차를 움직이는 함수
    public void randomCarMoving(){
        if (random.nextInt(10) >= 4) {
            location++;
        }
    }
}
