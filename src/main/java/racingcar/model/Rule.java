package racingcar.model;

public class Rule {
    //<메소드>
    // 자동차 이름 글자수 제한
    public void CarNameLengthLimit(String carName) {
        int lengthLimit=5;
        if (carName.length() > lengthLimit) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다. 프로그램을 종료합니다.");
        }
    }
}