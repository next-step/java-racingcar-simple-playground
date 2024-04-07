import java.util.Scanner;

public class Car {

    private int current_location = 0;

    public Car() {
    }

    public int scanner() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();

    }
    // 생성자
    public Car(int current_location) {
        this.current_location = current_location;
    }


    // 작동 함수
    public int getCurrent_location() {
        return current_location;
    }

    public void setCurrent_location(int current_location) {
        this.current_location = current_location;
    }

    public int getRandNum() {
        double ran = Math.random();
        return (int) (ran * 10);
    }

    public int check(int num, Car car) {
        if (num >= 4) {
            return forwardCar(car);
        }
        return stopCar(car);
    }


    public int forwardCar(Car car) {
        car.setCurrent_location(car.getCurrent_location() + 1);
        return current_location;
    }

    public int stopCar(Car car) {
        return current_location;
    }
}
