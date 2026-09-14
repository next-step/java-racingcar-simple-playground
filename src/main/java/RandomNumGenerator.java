public class RandomNumGenerator implements RandomNumber{
    private int bound;

    public RandomNumGenerator(int bound) {
        this.bound = bound;
    }

    @Override
    public int generate() {
        return (int) (Math.random() * bound);
    }
}
