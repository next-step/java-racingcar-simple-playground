public class Car {
    private static final int MOVE_THRESHOLD = 4;


    private String carName;
    private int carPosition = 0;
    private final MoveCondition moveCondition;

    public Car(String carName, MoveCondition moveCondition) {
        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalArgumentException("차의 이름이 비어있습니다");
        }
        this.carName = carName;
        this.moveCondition = moveCondition;
    }

    public int getPosition() {
        return carPosition;
    }

    public String getName() {
        return carName;
    }

    public void move(int value){
        if (moveCondition.isMovable(value)) {
            carPosition++;
        }
    }
}

