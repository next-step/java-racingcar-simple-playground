import java.util.Scanner;
import java.util.Random;

public class RaceSetting {
    protected Car[] cars;
    protected int carNum;
    protected int raceNum;
    private static final int MINIMUM_SPEED_TO_MOVE = 4;

    Random random = new Random();


    public void setCarNum(Scanner scanner) {
        System.out.println("출전한 자동차 수: ");
        this.carNum = scanner.nextInt();
    }

    private void setRaceNum(Scanner scanner) {
        System.out.println("몇 번 달릴꺼야: ");
        this.raceNum = scanner.nextInt();
    }

    public void createCars(Scanner scanner) {
        this.cars = new Car[carNum];
        for (int i = 0; i < carNum; i++) {
            System.out.println((i + 1) + "번 자동차 이름 : ");
            String temp = scanner.next();
            cars[i] = new Car();
            cars[i].setName(temp);
        }
    }

    public void runRace() {
        for (int i = 0; i < raceNum; i++) {
            {
                checkSpeedTOMove();
            }
        }
    }

    void checkSpeedTOMove() {
        for (Car car : cars) {
            isOverMinToMove(car);
        }

    }

    private void isOverMinToMove(Car temp) {
        if (random.nextInt(10) > MINIMUM_SPEED_TO_MOVE) {
            temp.upmoveCnt();
        }
    }


    RaceSetting() {
        Scanner scanner = new Scanner(System.in);
        setCarNum(scanner);
        setRaceNum(scanner);
        createCars(scanner);
        runRace();
        scanner.close();
    }
}
