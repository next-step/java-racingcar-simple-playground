import java.security.SecureRandom;
import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{

  private final SecureRandom secureRandom;

  public RandomNumberGenerator() {
    this.secureRandom = new SecureRandom();
  }

  @Override
  public int getNumber() {
    return this.secureRandom.nextInt(9);
  }
}
