package domain;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int CAR_NAME_MAX_LENGTH = 5;


    private String name;
    private int position = 0;
    private final MoveCondition moveCondition;

    public Car(String carName, MoveCondition moveCondition) {
        if (carName == null || carName.strip().isEmpty()) {
            throw new IllegalArgumentException("차의 이름이 비어있습니다");
        }
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다");
        }
        this.name = carName;
        this.moveCondition = moveCondition;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(int value){
        if (moveCondition.isMovable(value)) {
            position++;
        }
    }
}

