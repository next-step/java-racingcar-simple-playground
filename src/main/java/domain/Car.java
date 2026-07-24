package domain;

public class Car {
    private static  final  int MOVE_CONDITION = 4;

    private final String name; // 자동차의 이름 저장
    private int position; // 위치

    public Car(String name) { // 생성자(클래스 이름과 같)
        this.name = name; // 전달받은 이름 name변수에 저장
    }

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public  void move(int randomNumber) { // 자동차 움직이게 하는 메서드
        if (canMove(randomNumber)) { // 자동차 움직일 수 있는지 검사
            position++; // 괄호의 결과가 true면 자동차의 위치 1 증가
        }
    }

    private  boolean canMove(int randomNumber) {
        return randomNumber >= MOVE_CONDITION;
    }

    public boolean isSamePosition(int targetPosition) {
        return position == targetPosition;
    }

    Car copy() {
        return new Car(name, position);
    }

    public String getName() { // 자동차의 이름 알려주는 메서드
        return name;
    }

    public int getPosition() { // 위치
        return position;
    }
}