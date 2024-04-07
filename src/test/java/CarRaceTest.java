import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarRaceTest {

    private CarRace race;


    @Test
    @DisplayName("n대의 자동차를 생성하여 count번 움직이는 레이스를 진행한다.")
    void raceStartTest() {

        // 레이스용 차 생성
        race = new CarRace(3, new String[] {"포르쉐","제네시스","기아"});

        // 5바퀴 레이스 진행
        race.raceStart(5);

        // 우승자 선정
        List<Car> winnerCars = race.selectWinners();

        // winnerCars의 distance보다 거리가 더 큰 차가 있으면 실패
        int md = winnerCars.get(0).getDistance();
        boolean hasValueGreaterThanMd = winnerCars.stream().anyMatch(car -> car.getDistance() > md);
        assertFalse(hasValueGreaterThanMd);

    }
}