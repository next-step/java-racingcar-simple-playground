package domain;

public class CarName {

    final static private int MAX_LENGTH = 5;

    public static String form(String carName){
        ValidCarNameIsBlack(carName);
        ValidCarNameIsOverFive(carName);
        return carName;
    }

    private static void ValidCarNameIsBlack(String carName){
        if(carName.isBlank())
            throw new IllegalArgumentException("ERROR: 차 이름은 공백이 불가합니다.");
    }

    private static void ValidCarNameIsOverFive(String carName){
        if(carName.length() > MAX_LENGTH)
            throw new IllegalArgumentException("ERROR: 차 이름의 길이가 5이하여야 합니다.");
    }

}
