package domain;

public class Racing {

    private final Cars carList;

    public Racing(Cars carList) {
        this.carList = carList;
    }

    public void playRound() {
        carList.move();
    }

    public Cars findWinners() {
        return carList.findCarsInPosition(carList.getMaxDistance());
    }

}
