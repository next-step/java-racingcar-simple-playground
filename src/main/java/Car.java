public class Car {
    private int current_location = 0;

    public Car() {
    }


    // 생성자
    public Car(int current_location) {
        this.current_location = current_location;
    }

    // 작동 함수
    public int getCurrentLocation() {

        return current_location;
    }

    public void setCurrentLocation(int current_location) {
        this.current_location = current_location;
    }

}
