import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Racing
{
    private static final List<Car> cars = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    // 이름이 5글자 이하의 차만 필터링 후 Car 객체 생성
    private static String[] checkFiltering(String[] tempCarName)
    {
        String[] carName = Arrays.stream(tempCarName)
                .filter(name -> name.length() <= 5)
                .toArray(String[]::new);

        // 에러 처리
        if (carName.length == 0)
            throw new IllegalArgumentException("There is no car.");

        return carName;
    }

    private static void addCar(String curCarName)
    {
        Car curCar = new Car();
        curCar.setCarName(curCarName);
        cars.add(curCar);
    }

    public static void startRace(int raceCount)
    {
        for (int i=0; i<raceCount; i++)
        {
            cars.forEach(Car::MoveCar);
            System.out.println();
        }
    }

    private static int findMaxPos()
    {
        return cars.stream()
                .mapToInt(Car::getCarPos)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("5글자 이내인 차가 존재하지 않습니다."));
    }

    public static List<String> findWinner()
    {
        return cars.stream()
                .filter(car -> car.getCarPos() == findMaxPos())
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public static void startGame()
    {
        // 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] tempCarName = scanner.nextLine().split(",");

        // Car 객체 생성
        for (String name: checkFiltering(tempCarName))
            addCar(name);

        // 시도 횟수 입력
        System.out.println("시도할 횟수는 몇회인가요?");
        int raceCount = scanner.nextInt();

        // 에러 처리
        if (raceCount <= 0)
            throw new IllegalArgumentException("자연수를 입력해 주세요.");

        // 경주 진행
        System.out.println("\n실행 결과");
        startRace(raceCount);

        // 승자 출력
        List<String> winner = findWinner();
        System.out.println(String.join(", ", winner) + "가 최종 우승했습니다.");
    }

    public static void main(String[] args)
    {
        startGame();
    }
}
