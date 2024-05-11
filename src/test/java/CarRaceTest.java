import domain.Car;
import domain.CarRace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarRaceTest {



    @Test
    @DisplayName("n대의 자동차를 생성하여 count번 움직이는 레이스를 진행한다.")
    void raceStartTest() {

        final String[] name = {"a", "b", "c"};
        final CarRace race = new CarRace(name, 5,3);
        final int tryCount = race.getTryCount();

        for(int i=0;i<tryCount;i++){
            race.raceOneLap();
        }

        List<Car> winnerCars = race.findWinners();

        int md = winnerCars.get(0).getDistance();
        boolean hasValueGreaterThanMd = winnerCars.stream().anyMatch(car -> car.getDistance() > md);
        assertFalse(hasValueGreaterThanMd);

    }
}