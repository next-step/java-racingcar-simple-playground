public class RacingGame {
    public void run(Car car) {
        int number = (int) (Math.random() * 10);
        car.move(number);
    }
}
