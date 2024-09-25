package domain;

public class CarMove {
    private RandomGenerator randomGenerator = new RandomGenerator();

    //자동차 움직이는 메서드
    public void moveCar(Car car){
        int num = randomGenerator.getRandomNumber();

        if (num>=4){
            car.move();
        }
    }
}
