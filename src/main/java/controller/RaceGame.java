package controller;

import objects.Car;
import objects.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RaceGame {

    private static Cars carRepository;
    private static List<Car> winningCars = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int gameCount;

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        String[] names = input.split(",");
        System.out.println("시도할 회수는 몇회인가요?");
        gameCount = scanner.nextInt();

        carRepository = new Cars();


        for (int i = 0; i < names.length; i++) {
            Car myCar = new Car(names[i]);
            carRepository.getCars().add(myCar);

        }

        for (int i = 0; i < gameCount; i++) {

            carRepository.race();

        }

        carRepository.makeWinningCars();
        carRepository.winner();


    }
}
