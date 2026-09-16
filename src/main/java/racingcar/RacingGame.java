package racingcar;

public class RacingGame {
    private final Cars cars;
    private final RandomNumber randomNumber;
    private final int raceCount;

    public RacingGame(Cars cars, RandomNumber randomNumber, int raceCount) {
        this.cars = cars;
        this.randomNumber = randomNumber;
        this.raceCount = raceCount;
    }

    public void carRaceOnce() {
        cars.move(randomNumber);
    }

    //한 라운드당 끊어서 경주를 해야하므로 밑에껀 주석 처리함
    //public void carRace() {
    //    for (int i = 0; i < raceCount; i++) {
    //        cars.move(randomNumber);
    //    }
    //}
}
