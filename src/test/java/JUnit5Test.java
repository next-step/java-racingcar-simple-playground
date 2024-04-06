import model.Car;
import model.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import utils.RandomNumberGenerator;

import java.util.List;

public class JUnit5Test {

    @Nested
    @DisplayName("generate 메서드 0~9 정수 반환 테스트")
    class GenerateMethodTest {
        @Test
        @DisplayName("generate 메서드는 0에서 9사이의 정수를 반환한다.")
        void testGenerateMethodReturnZeroAndNine() {
            List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
            int testNumber = RandomNumberGenerator.generate();
            if (!numbers.contains(testNumber)) {
                throw new RuntimeException("generate 메서드가 0에서 9사이의 정수를 반환하지 않습니다.");
            }
        }
    }

    @Nested
    @DisplayName("우승자를 구하는 기능 테스트")
    class CalculateWinnerMethodTest {
        @Test
        @DisplayName("calculateWinner 메서드는 가장 높은 점수를 가진 자동차를 우승자로 결정한다.")
        void testCalculateWinnersMethodReturnAccurateWinners() {
            int raceCount = 3;

            Cars cars = new Cars();
            Car car1 = new Car("붕붕이");
            Car car2 = new Car("따릉이");
            Car car3 = new Car("쌩생이");

            cars.save(car1);
            cars.save(car2);
            cars.save(car3);
            cars.move(raceCount);

            int maxScore = 0;

            for (Car car : cars.getCars()) {
                if (car.getScore() > maxScore) {
                    maxScore = car.getScore();
                }
            }

            final int winnerScore = maxScore;
            List<Car> topScorer = cars.getCars().stream().filter(car -> car.getScore() == winnerScore).toList();

            List<Car> winners = cars.getWinners();
            if (!winners.equals(topScorer)) {
                throw new RuntimeException("calculateWinner 메서드는 정확한 우승자를 반환하지 않습니다.");
            }
        }
    }
}
