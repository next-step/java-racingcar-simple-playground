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
        for (String name : carNamesArr) {
            carNameLengthLimit(name);
            Car car = new Car(name);
            carList.add(car);
        }
        return carList;
    }

     //자동차 이름 글자수 제한
    public void carNameLengthLimit(String carName) {
        int lengthLimit=5;
        if (carName.length() > lengthLimit) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다. 프로그램을 종료합니다.");
        }
    }
}
