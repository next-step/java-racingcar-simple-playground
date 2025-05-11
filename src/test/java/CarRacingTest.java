import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 경주 테스트")
public class CarRacingTest {

	private final Random random = new Random();
	private final int randomNumToForward = random.nextInt(6) + 4;
	private final int randomNumToStop = random.nextInt(4);
	private int distance = 0;

	@Test
	@DisplayName("자동차가 전진하는지 확인한다.")
	void is_forward() {
		boolean isForward = randomNumToForward >= 4 && randomNumToForward <= 9;
		Assertions.assertTrue(isForward);
	}

	@Test
	@DisplayName("자동차가 멈추는지 확인한다.")
	void is_stop() {
		boolean isStop = randomNumToStop >= 0 && randomNumToStop <= 3;
		Assertions.assertTrue(isStop);
	}

	@Test
	@DisplayName("자동차를 전진시킨다.")
	void forward_distance() {

		if (randomNumToForward >= 4 && randomNumToForward <= 9) {
			distance++;
		}

		Assertions.assertTrue(distance >= 1);
	}

	@Test
	@DisplayName("자동차가 멈춘다.")
	void stop_distance() {
		if (randomNumToStop >= 0 && randomNumToStop <= 3) {
			distance = distance + 0;
		}

		Assertions.assertEquals(0, distance);
	}

}
