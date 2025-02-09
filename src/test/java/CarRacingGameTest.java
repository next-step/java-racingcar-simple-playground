import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class CarRacingGameTest {

    @Test
    void 자동차_경주_이동_테스트() {
        Car car = new Car("포니");
        int initialLocation = car.getLocation();

        for (int i = 0; i < 100; i++) {
            car.move();
        }

//        현재 위치값이 초기값 이상이면 테스트 통과
        assertTrue(car.getLocation() >= initialLocation);
    }

    @Test
    void 우승자_테스트() {
        List<String> carNames = Arrays.asList("쿠페", "다시아", "버기", "피코버스", "오토바이");
        CarRacingGame game = new CarRacingGame(carNames, 5);
        game.race();

        List<Car> winners = game.getWinners();
        int maxLocation = winners.get(0).getLocation(); // 우승자의 위치 저장

//        우승자들의 위치가 같은 지 확인
        for (Car winner : winners) {
            assertEquals(maxLocation, winner.getLocation());
        }
    }
}
