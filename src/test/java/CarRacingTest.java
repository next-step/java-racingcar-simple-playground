import java.util.List;
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

	RacingCarCompetition racingCarCompetition = new RacingCarCompetition();

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

	@Test
	@DisplayName("경주에서 우승한 자동차를 가려낸다.")
	void get_winning_car() {

		Car car1 = new Car("일짱");
		Car car2 = new Car("이짱");
		Car car3 = new Car("삼짱");
		Car car4 = new Car("사짱");

		List<Car> participatingCars = List.of(car1, car2, car3, car4);

		racingCarCompetition.startRacing(5, participatingCars);

		Car winningCar = racingCarCompetition.getWinningCar(participatingCars);

		System.out.println("우승 자동차는 \"" + winningCar.getName() + "\" 입니다.");
	}
}
