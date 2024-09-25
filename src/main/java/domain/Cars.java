package domain;

import domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public static List<Car> cars;
    public static String[] carNames;

    //자동차 문자열 분리 메서드
    public static void splitCarName(String input){
        checkNull(input);
        carNames = input.split(",");
    }

    private static int carSize(String[] carNames){
        return carNames.length;
    }

    //경주 자동차 생성 메서드
    public static void generateCar(){
        cars = new ArrayList<>(carSize(carNames));
        for(String carName : carNames){
            checkNull(carName);
            checkLength(carName);
            cars.add(new Car(carName));
        }
    }

    //경주 자동차 이동 메서드
    public static void moveCars(){
        for(Car car : cars){
            car.moveCar();
        }
    }

    private static void checkNull(String carName){
        if(carName == null || carName.isBlank()){
            throw new IllegalArgumentException("이름은 공백으로 입력될 수 없습니다.");
        }
    }

    private static void checkLength(String carName){
        if(carName.length()>5){
            throw new IllegalArgumentException("이름은 최대 5자까지만 가능합니다.");
        }
    }

}
