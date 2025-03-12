
public class RandomGenerator implements NumberGenerator {

    @Override
    public int getRandomNumber() {
        return (int) (Math.random() * 10);
    }
}
