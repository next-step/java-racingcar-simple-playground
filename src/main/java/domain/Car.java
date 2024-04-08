package domain;

public class Car {
    private int current_location = 0;
    private String name;

    public Car() {
    }


    // 생성자
    public Car(int current_location, String name) {
        this.current_location = current_location;
        this.name = name;
    }

    // 작동 함수
    public int getCurrentLocation() {

        return current_location;
    }

    public String getName() {
        return name;
    }

    public void setCurrentLocation(int current_location) {
        this.current_location = current_location;
    }

    public void setName(String name){
        this.name = name;
    }

}
