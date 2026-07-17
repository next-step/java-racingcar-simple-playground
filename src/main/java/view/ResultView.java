package view;

import domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ResultView {
    /*
     * 자동차의 이동거리를 '-'로 시각적으로 출력
     * */
    // 리펙터링: ResultView로 이동(출력만 담당)
    public static void printDistance(Car car) {
        for (int i = 0; i < car.getTotalDistance(); i++) {
            System.out.print("-");
        }
    }

    /*
     * 현재 자동차들의 이동 거리 출력하기
     * */
    // 리펙터링: ResultView로 이동
    public static void printCarDistance(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            ResultView.printDistance(car);
            System.out.println();
        }
        System.out.println();
    }
    /*
     * 우승 자동차 출력
     * */
    // 리펙터링: winners를 매개 변수로 받아 사용
    public static void printWinners(List<Car> winners) {

        StringJoiner joiner = new StringJoiner(", "); // 중요! StringJoiner
        // StringJoiner 없이 구현하려면 쉼표 출력 여부를 검사하는 메서드 추가 필요

        for (Car car : winners) {
            joiner.add(car.getName());
        }
        System.out.println(joiner + "가 최종 우승했습니다.");
    }
}
