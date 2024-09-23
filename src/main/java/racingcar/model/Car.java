package racingcar.model;

public class Car {
    //<필드>
    private String name;
    private int position;


    //<생성자>
    public Car(String name) {
        this.name = name;
        this.position = 0;
    }


    //<메소드>
    //getter
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    //위치 설정
    public void setPosition(int positon) {
        this.position = positon;
    }
}
