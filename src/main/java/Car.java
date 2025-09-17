public class Car {
    private static final int MOVE_CONDITION = 4; // 전진 조건
    private String name;
    private int position = 0;


    public Car(){}
    public Car(String name) {
        this.name = name;
    }

    // 자동차의 이동 로직. 외부에서 받은 랜덤 값에 따라 스스로 움직입니다.
    public void move(int randomNumber) {
        if (randomNumber >= MOVE_CONDITION) {
            this.position++;
        }
    }
    
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
