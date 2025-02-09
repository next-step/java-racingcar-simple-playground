import java.util.Arrays;
import java.util.Scanner;

public class GameStart {
    private static Car[] cars;
    private static int times;
    private static FindWinCar race;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 자동차 이름
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = in.nextLine().split(",");

        for (String name : carNames){
            if (name.length() > 5 || name.isEmpty()){
                throw new IllegalArgumentException();
            }
        }

        // 객체 생성
        cars = Arrays.stream(carNames)
                    .map(Car::new)
                    .toArray(Car[]::new);

        // 이동 횟수
        System.out.println("시도할 회수는 몇회인가요?");
        times = in.nextInt();
        if (times < 0){
            throw new IllegalArgumentException();
        }

        // 경기 진행
        race = new FindWinCar(cars.length, cars);
        for (int i = 0; i < times; ++i){
            print(race.getLocate());
            race.move();
            System.out.println();
        }

        // 최종 출력
        print(race.getLocate());
        String winNames = Arrays.stream(race.findWin())
                                .map(Car::getName)
                                .reduce((a, b) -> a + ", " + b)
                                .orElse("");
        System.out.println(winNames + "가 최종 우승했습니다.");

        in.close();
    }

    private static void print(int[] locate){
        for (int i = 0; i < cars.length; ++i){
            System.out.println(cars[i].getName() + " : " + locate[i]);
        }
    }

}
