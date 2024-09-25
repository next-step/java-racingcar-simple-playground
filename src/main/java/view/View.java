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

    public static int inputTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        return input.nextInt();
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

}
