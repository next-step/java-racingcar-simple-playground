package view;

import domain.Car;

import java.util.List;
import java.util.Scanner;

public class View {
    static Scanner input = new Scanner(System.in);

    public static String inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return input.nextLine();
    }

    //자동차 문자열 분리 메서드
    public static String[] splitCarName(String input) {
        checkNull(input);
        return input.split(",");
    }

    public static int inputTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");

        int tryCount = input.nextInt();
        checkNum(tryCount);

        return tryCount;
    }

    private static void checkNum(int tryCount){
        if(tryCount<1){
            throw new IllegalArgumentException("시도 횟수는 자연수만 가능합니다.");
        }
    }

    public static void printRacingGame(List<Car> cars){
        String position = "-";
        for(Car car : cars){
            System.out.println(car.getName()+" : "+position.repeat(car.getPosition()));
        }
        System.out.println(" ");
    }

    public static void printWinner(List<String> winners) {
        String result = String.join(", ",winners);
        System.out.println(result+"가 최종 우승했습니다.");
    }

    private static void checkNull(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException("이름은 공백으로 입력될 수 없습니다.");
        }
    }

}
