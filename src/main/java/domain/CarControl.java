package domain;

public class CarControl {
    private static final int MOVE_STANDARD = 4;

    //자동차 움직임 여부 판단 메서드
    public static boolean isMovable(){
        int num = RandomGenerator.getRandomNumber();
        return num>=MOVE_STANDARD;
    }
}
