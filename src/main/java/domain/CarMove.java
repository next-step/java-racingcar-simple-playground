package domain;

public class CarMove {
    private RandomGenerator randomGenerator = new RandomGenerator();

    // 기본 생성자
    public CarMove() {
        this.randomGenerator = new RandomGenerator();  // 기본적으로 실제 RandomGenerator 사용
    }

    // RandomGenerator를 주입받는 생성자
    public CarMove(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }


    //자동차 움직이는 메서드
    public void moveCar(Car car) {
        int num = randomGenerator.getRandomNumber();

        if (num >= 4) {
            car.move();
        }
    }
}
