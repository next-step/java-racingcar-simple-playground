package utils;

import java.util.Random;

public class NumberUtils {

	private static final Random random = new java.util.Random();

	public static int getRandomNumberZeroToThree() {
		return random.nextInt(4);
	}

	public static int getRandomNumberFourToNine() {
		return random.nextInt(6) + 4;
	}

	public static int getRandomNumberZeroToNine() {
		return random.nextInt(10);
	}

}
