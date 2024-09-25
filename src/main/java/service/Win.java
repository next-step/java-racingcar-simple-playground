package service;

import domain.Car;

import java.util.List;

public class Win {

    //우승자 계산
    public List<Car> findWinners(List<Car> cars){
        int maxPosiiton = cars.stream()
                                .mapToInt(Car::getPosition)
                                .max()
                                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosiiton)
                .toList(); //우승자 리스트 반환
    }

    //우승자 출력
    public void printWinners(List<Car> winners){
        System.out.print("우승자: ");
        String winnerNames = winners.stream()
                .map(car -> car.getCarName().getName())
                .reduce((name1, name2) -> name1 + ", " + name2)
                .orElse("");
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

}
