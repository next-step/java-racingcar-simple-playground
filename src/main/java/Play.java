import java.util.ArrayList;
import java.util.List;

public class Play {
    List<Car> cars;

    public Play(List<Car> cars) {
        this.cars = cars;
    }
    void playRound(int round) {
        for (int i = 0; i < round; i++) {
            playRoundCycle();
        }
        getWinners();
    }

    void getWinners() {

    }

    void playRoundCycle() {
        for (int i = 0; i < cars.size(); i++) {
            int presentNum = cars.get(i).setNum();
            setState(presentNum, i);
        }
    }

    int setState(int num, int i) {
        if (num >= 4) {
            cars.get(i).moveCar();
            return cars.get(i).position;
        }
        cars.get(i).stopCar();
        return cars.get(i).position;
    }

}
