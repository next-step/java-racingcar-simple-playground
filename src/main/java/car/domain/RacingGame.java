package car.domain;

import static car.domain.model.Judge.findWinners;

import car.domain.model.CarGroup;
import car.domain.model.Judge;
import car.domain.model.MovingCar;
import car.domain.model.Round;
import car.domain.model.Rounds;
import car.domain.strategy.MovingStrategy;
import java.util.List;

public class RacingGame {

    private final CarGroup carGroup;
    private final Rounds rounds;

    public RacingGame(CarGroup carGroup, int tryCount) {
        this.carGroup = carGroup;
        this.rounds = new Rounds(tryCount);
    }

    public void runRace(MovingStrategy strategy) {
        for (int i = 0; i < rounds.getTotalCount(); i++) {
            carGroup.moveAllCars(strategy);
            rounds.addReport(new Round(carGroup.getCars())); // 결과 기록
        }
    }

    public List<Round> getResultHistory() {
        return rounds.getHistory();
    }

    public List<MovingCar> getWinners() {
        return findWinners(carGroup.getCars());
    }
}


