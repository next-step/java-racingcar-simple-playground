package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CreateObjectCars {
    String splitSign=",";
    //<메소드>
    //문자열 잘라서 배열에 넣기
    public String[] splitCarNames(String carNamesStr) {
        String[] carNamesArr = carNamesStr.split(splitSign);
        return carNamesArr;
    }

    //자동차 객체 생성 및 리스트에 추가
    public List<Car> createCarList(String[] carNamesArr) {
        List<Car> carList = new ArrayList<>();
        Rule rule = new Rule();
        for (String name : carNamesArr) {
            rule.CarNameLengthLimit(name);
            Car car = new Car(name);
            carList.add(car);
        }
        return carList;
    }
}
