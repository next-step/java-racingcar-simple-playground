import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n, Test;
        String names_tmp;
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();

        Scanner sc = new Scanner(System.in);
        names_tmp = sc.nextLine();
        String[] names = names_tmp.split(","); //이름들 저장
        n = names.length;
        Car[] cars = new Car[n];

        for (int i = 0; i < n; i++) {
            Car car = new Car(0, names[i], numberGenerator);
            cars[i] = car;
        }

        System.out.println("시도할 회수는 몇회인가요?");
        Test = sc.nextInt(); //경기 횟수

        System.out.println("실행 결과");
        Racing racing = new Racing(cars);

        racing.carRacing(Test);
        Car[] winCars = racing.winCars();

        for (int i = 0; i < winCars.length - 1; i++) {
            System.out.println(winCars[i].getName() + ", ");
        }
        System.out.println(winCars[winCars.length - 1].getName() + "가 최종 우승했습니다.");

    }
}
