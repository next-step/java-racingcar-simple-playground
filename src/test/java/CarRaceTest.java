import domain.Car;
import domain.CarRace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarRaceTest {

    private CarRace race;
    private String[] carNames;

    private void createCar() {
        // 레이스용 차 생성
        final var carNames = InputView.getCarNames();
        final var tryCount = InputView.getTryCount();

        race = new CarRace(carNames, tryCount);
    }

    @Test
    @DisplayName("n대의 자동차를 생성하여 count번 움직이는 레이스를 진행한다.")
    void raceStartTest() {

        createCar();

        // 5바퀴 레이스 진행
        race.raceStart();

        // 우승자 선정
        List<Car> winnerCars = race.getWinners();

        // winnerCars의 distance보다 거리가 더 큰 차가 있으면 실패
        int md = winnerCars.get(0).getDistance();
        boolean hasValueGreaterThanMd = winnerCars.stream().anyMatch(car -> car.getDistance() > md);
        assertFalse(hasValueGreaterThanMd);

    }
}