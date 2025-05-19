package utils;

public class RandomNumberGenerator implements NumberGenerator {

    private final java.util.Random random = new java.util.Random();

	@Override
	public int generate() {
	    return random.nextInt(10);
	}
}
