public class CarController {

    private final MoveStrategy moveStrategy = new MoveStrategy();

    void moveIfCan(int num, Car car) {
        if (moveStrategy.canMove(num)) {
            car.move();
        }
    }
}
