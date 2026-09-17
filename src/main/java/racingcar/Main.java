package racingcar;

import static racingcar.Cars.createCars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //자동차 이름 입력하여 생성시키기 --> 둘이 쪼개야할거같음

        //자동차 이름 입력받기
        String[] carNameArray = readCarName();
        //자동차 생성시키기
        Cars carsList = createCars(carNameArray);
        //시도할 횟수 받기
        int tryCount = readTryCount();
        System.out.println();
        //시도 횟수만큼 경주시키기 (단, 경주할떄마다 값 출력하기)
        raceCars(carsList, tryCount);
        //최종 우승자 출력하기
        printFinalWinners(carsList.findWinner());
    }


    //자동차 이름 입력받기
    //static 쓰면 클래스 전체에서 공유하는거라서, 객체 생성 안하고 바로 쓸수있음
    private static String[] readCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = scanner.nextLine();
        //쉼표기준으로 잘라서 넣게끔 하는거구나 split()
        return carNames.split(",");
    }

    //자동차 생성시키기는 Cars로 옮겼음

    //시도할 횟수 받기
    private static int readTryCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return scanner.nextInt();
        //nextInt()는 콘솔 입력에서 정수 하나(다음 토큰)를 읽어서 int로 반환하는 메서드임.
    }

    //시도 횟수만큼 경주시키기 (단, 경주할떄마다 값 출력하기)
    private static void raceCars(Cars carsList, int tryCount) {
        DefaultRandomNumber defaultRandomNumber = new DefaultRandomNumber();
        RacingGame racingGame = new RacingGame(carsList, defaultRandomNumber);
        for (int i = 0; i < tryCount; i++) {
            racingGame.carRaceOnce();
            //경주할때마다 값 출력하기
            printRound(carsList);
        }
    }

    //라운드간 우승자 출력하기
    private static void printRound(Cars carsList) {
        for (Car car : carsList.getCars()) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getCarPosition()));
        }
        System.out.println();
    }
    //repeat()는 문자열 반복 메서드임. car.getCarPosition()만큼 "-"를 반복해서 출력하는거.

    //최종 우승자 출력하기
    private static void printFinalWinners(List<Car> winners) {
        List<String> names = new ArrayList<>();
        for (Car car : winners) {
            names.add(car.getCarName()); // Car에서 이름만 뽑아서 새 리스트에 담음
        }
        System.out.println(String.join(", ", names) + "가 최종 우승했습니다.");
    }
    //String.join(", ", ["neo", "brown"]) → "neo, brown" 이렇게 합쳐주는거임.

}



