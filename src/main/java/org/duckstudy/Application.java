package org.duckstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.duckstudy.game.CarRacer;
import org.duckstudy.movingcar.Car;
import org.duckstudy.movingcar.CarMover;
import org.duckstudy.movingcar.RandomValueGenerator;

public class Application {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.");
        String[] nameList = br.readLine().split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int repetitionNum = Integer.parseInt(br.readLine());

        CarRacer carRacer;
        try {
            carRacer = new CarRacer(new CarMover(new RandomValueGenerator()), nameList.length, repetitionNum,
                    nameList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("\n실행 결과");
        ArrayList<Car> winnerList = carRacer.play();
        if (winnerList.isEmpty()) {
            System.out.println("우승자가 없습니다.");
            return;
        }
        String winnerNames = winnerList.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
