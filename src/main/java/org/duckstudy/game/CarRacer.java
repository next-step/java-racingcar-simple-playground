package org.duckstudy.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.duckstudy.movingcar.Car;
import org.duckstudy.movingcar.CarMover;
import org.duckstudy.movingcar.RandomValueGenerator;

public class CarRacer {
    private final CarMover carMover;
    private final int participantNum;
    private final ArrayList<Car> carList = new ArrayList<>();
    private final int repetitionNum;
    private final String[] nameList;

    public CarRacer() {
        this(new CarMover(new RandomValueGenerator()), 0, 0, new String[0]);
    }

    public CarRacer(CarMover carMover, int participantNum, int repetitionNum, String[] nameList) {
        this.carMover = carMover;
        this.participantNum = participantNum;
        this.nameList = nameList;
        addCar(participantNum, nameList);
        this.repetitionNum = repetitionNum;
    }

    private void addCar(int participantNum, String[] nameList) {
        for (int i = 0; i < participantNum; i++) {
            carList.add(new Car(nameList[i]));
        }
    }

    public ArrayList<Car> play() {
        for (int i = 0; i < repetitionNum; i++) {
            carMover.move(carList);
        }
        return calculateWinner(carList);
    }

    public ArrayList<Car> calculateWinner(ArrayList<Car> carList) {
        ArrayList<Car> winnerList = new ArrayList<>();
        long maxPosition = 0;

        for (Car car : carList) {
            maxPosition = getMaxPosition(winnerList, maxPosition, car);
        }
        return winnerList;
    }

    private long getMaxPosition(ArrayList<Car> winnerList, long maxPosition, Car car) {
        if (maxPosition < car.getPosition()) {
            maxPosition = car.getPosition();
            winnerList.clear();
            winnerList.add(car);
            return maxPosition;
        }
        if (maxPosition == car.getPosition()) {
            winnerList.add(car);
        }
        return maxPosition;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.");
        String[] nameList = br.readLine().split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int repetitionNum = Integer.parseInt(br.readLine());

        System.out.println("\n실행 결과");
        CarRacer carRacer = new CarRacer(new CarMover(new RandomValueGenerator()), nameList.length, repetitionNum,
                nameList);
        ArrayList<Car> winnerList = carRacer.play();

        if (winnerList.isEmpty()) {
            System.out.println("우승자가 없습니다.");
        }
        String winnerNames = winnerList.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
