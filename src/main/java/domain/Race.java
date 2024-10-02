package domain;

import service.Win;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Race {
    private List<Car> cars;
    private int nRound;
    private CarMove carMove = new CarMove();
    private Win winService = new Win();

    public Race(List<Car> cars, int nRound) {
        this.cars = cars;
        this.nRound = nRound;
    }

    //경주 시작
    public void startRace() {
        for (int i = 0; i < nRound; i++) {
            System.out.println();
            for (Car car : cars) {
                carMove.moveCar(car);
                car.printPosition();
            }
        }
        System.out.println(" ");

        // 우승자 찾기, 출력
        List<Car> winners = winService.findWinners(cars);
        winService.printWinners(winners);
    }

    //입력받기
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNamesInput = scanner.nextLine();
        List<String> carNames = Arrays.asList(carNamesInput.split(","));
        List<Car> cars = carNames.stream()
                .map(Car::new) // car 생성자에게 이름 전달
                .collect(Collectors.toList());

        // 시도할 회수 입력받기
        System.out.println("시도할 회수는 몇 회인가요?");
        int nRound = scanner.nextInt();

        //경주
        Race race = new Race(cars, nRound);
        race.startRace();
    }
}
