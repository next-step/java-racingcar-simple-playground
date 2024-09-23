public class CarControl {
    private static final int MOVE_STANDARD = 4;

    public static boolean isMovable(){
        int num = RandomGenerator.getRandomNumber();
        return num>=MOVE_STANDARD;
    }
}
