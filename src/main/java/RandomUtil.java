public class RandomUtil {
    private static final int RANDOM_LIMIT = 10;

    public static int randomGenerator(){
        //0 <= value <= 9
        return (int)Math.floor((Math.random() * RANDOM_LIMIT));
    }
}
