package racinggame.model.car;

import racinggame.model.car.policy.strategy.MoveStrategy;

import java.util.Objects;

public class Car {
    private final String name;
    private int movedDistance=0;

    private final MoveStrategy moveStrategy;

    public Car(String name,MoveStrategy moveStrategy) {
        if(name==null){
            throw new IllegalArgumentException("이름은 null 일 수 없습니다.");
        }
        if(name.isBlank()){
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
        this.name = name;
        this.moveStrategy=moveStrategy;
    }

    public void move(){
        int distance=moveStrategy.addStepSize();
        movedDistance+=distance;
    }

    public int getMovedDistance() {
        return movedDistance;
    }
    public String getName() {
        return name;
    }
}
