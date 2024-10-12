package util;

import java.security.SecureRandom;

public class NumberGenerateUtil {

  public int generateRandomNumber() {
    SecureRandom secureRandom = new SecureRandom();
    return secureRandom.nextInt(10);
  }
}
