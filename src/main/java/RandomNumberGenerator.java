import java.security.SecureRandom;

public class RandomNumberGenerator implements NumberGenerator{
    private final SecureRandom random = new SecureRandom();

    @Override
    public int getNumber() {
        return random.nextInt(0,9);
    }
}
