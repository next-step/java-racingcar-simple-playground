package domain;

import domain.Car;
import domain.MoveCar;
import view.Print;

import java.util.ArrayList;
import java.util.Scanner;

public class Race {
    public Race() {

    }

    public int carCount() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public int timeCount() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public String setNames() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public void checkNameLength(String name) throws Exception {
        if (name.length() > 5) {
            throw new Exception("글자수가 5글자 넘음");
        }
    }

    public String[] sepNames(String names) {
        return names.split(",");
    }

    public Car[] getCar(int carCount, String[] nameList) {

        Car[] carList = new Car[carCount];

        for (int i = 0; i < carCount; i++) {
            Car car = new Car();
            carList[i] = car;
            carList[i].setName(nameList[i]);
        }

        return carList;
    }

    public Car[] initCar(int carCount, String[] nameList) {

        return getCar(carCount, nameList);
    }


    //    public ArrayList<domain.Car> startRace(domain.Car[] carList, int carCount, int timeCount) {
    public Car[] startRace(Car[] carList, int carCount) {
        MoveCar moveCar = new MoveCar();
        Print print = new Print();
        // 전체 횟수 반복추가
        for (int i = 0; i < carCount; i++) {
            moveCar.check(moveCar.getRandNum(), carList[i]);

            print.printRacing(carList[i].getName(), carList[i].getCurrentLocation());

        }
        System.out.println();
        return carList;
    }


    public int getMaxNumber(Car car, int max, int index, int i) {

        if (car.getCurrentLocation() > max) {
            return i;
        }

        return index;
    }

    public ArrayList<Car> getWinner(Car[] carList) {
        int max = carList[0].getCurrentLocation();
        int index = 0;

        for (int i = 0; i < carList.length; i++) {
            index = getMaxNumber(carList[i], max, index, i);
        }

        // 중복 우승자 구하기
        ArrayList<Car> winners = new ArrayList<Car>();
        max = carList[index].getCurrentLocation();

        for (int i = 0; i < carList.length; i++) {
            checkWinnersInArray(carList, winners, max, i);
        }

        return winners;
    }

    public void checkWinnersInArray(Car[] carList, ArrayList<Car> winners, int max, int i) {
        if (checkDuplication(carList, max, i) != -1) {
            winners.add(carList[checkDuplication(carList, max, i)]);
        }
    }

    public int checkDuplication(Car[] carList, int max, int i) {
        if (carList[i].getCurrentLocation() == max) {
            return i;
        }

        return -1;
    }
}
