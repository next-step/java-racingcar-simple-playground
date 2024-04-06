import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarRaceTest {

    private List<Car> createdCars;
    private List<Car> winnerCars;


    // CarRace.java 에 차를 생성하는 함수 및 생성자를 사용하는 것이 바람직하지 않다고 생각
    void createCar(){
        createdCars = new ArrayList<>();
        for(int i =0;i<9;i++)   createdCars.add(new Car("car"+ (i+1)));
    }

    @Test
    @DisplayName("n대의 자동차를 생성하여 count번 움직이는 레이스를 진행한다.")
    void raceStartTest() {

        // 레이스용 차 생성
        createCar();

        // 5바퀴 레이스 진행
        createdCars = CarRace.raceStart(5, createdCars);

        // 우승자 선정
        winnerCars = CarRace.selectWinners(createdCars);

        // winnerCars의 distance보다 거리가 더 큰 차가 있으면 실패
        int md = winnerCars.get(0).getDistance();
        boolean hasValueGreaterThanMd = winnerCars.stream().anyMatch(car -> car.getDistance() > md);
        assertFalse(hasValueGreaterThanMd);

    }
}