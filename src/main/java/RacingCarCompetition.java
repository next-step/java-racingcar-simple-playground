import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class RacingCarCompetition {

	CarRacing carRacing = new CarRacing();
	private final Random random = new Random();

	public void startRacing(int roundNum, List<Car> participatingCars) {
		if (participatingCars.isEmpty()) {
			throw new IllegalStateException("경주에 참가한 자동차가 없습니다.");
		}

		for (int i = 0; i < roundNum; i++) {
			doRacing(participatingCars);
		}
	}

	public void doRacing(List<Car> participatingCars) {
		for (Car car : participatingCars) {
			int randomNum = random.nextInt(10);
			car.setDistance(carRacing.moveCar(randomNum, car.getDistance()));
		}
	}

	public Car getWinningCar(List<Car> participatingCars) {
		return participatingCars.stream()
			.sorted(Comparator.comparing(Car::getDistance).reversed())
			.findFirst()
			.orElseThrow(() -> new IllegalStateException("경주에 참가한 자동차가 없습니다."));
	}
}
