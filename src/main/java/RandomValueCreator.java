import java.util.Map;

public class RandomValueCreator {
    public static int createRandomValue() {
        //Q : Random()과 Math.random() 차이점
        final double randomValue = Math.random();
        return (int) (randomValue * 10);
    }

}