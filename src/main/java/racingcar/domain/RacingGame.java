package racingcar.domain;

import java.util.List;

public class RacingGame {
    private List<Car> racingCars;
    private final int lapCount;
    private RandomNumGenerator randomNumGenerator;

    public RacingGame(List<Car> racingCars, int lapCount) {
        this.racingCars = racingCars;
        this.lapCount = lapCount;
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public int getLapCount() {
        return lapCount;
    }

    //한번의 lap에 대한 메서드 -  List<Car>형태로 반환할 것.. 반환을 받아서 print를 application에서 호출할것이므로..
    public List<Car> startLap() {
        for (Car racingCar : racingCars) {
            racingCar.moveCar(randomNumGenerator.makeNum());   //실제 랜덤넘버 만드는 것이 호출될 것임
        }
        return racingCars;
    }

    //lap을 lapCount만큼 순회하도록 하는것을 둬야할까? 이걸 여기에 두면 출력이 애매해지는데.


}
