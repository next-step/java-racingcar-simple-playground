public class RaceWinner extends RaceSetting {
    int winnerCnt = -1;

    RaceWinner() {
        super();
        findWinnerCnt();
        printAllCarMove();
        printWinner();
    }

    void printAllCarMove() {
        for (Car car : cars) {
            System.out.println("이름 : " + car.getName() + " Move: " + car.getmoveCnt());
        }
    }

    void findWinnerCnt() //
    {
        for (Car car : cars) {
            setWinnerCnt(car);
        }
    }

    private void setWinnerCnt(Car car) {
        if (winnerCnt < car.getmoveCnt()) {
            winnerCnt = car.getmoveCnt();
        }
    }

    void printWinner() {
        System.out.println("우승 : ");
        for (Car car : cars) {
            setWinnerCar(car);
        }
    }

    private void setWinnerCar(Car car) {
        if (winnerCnt == car.getmoveCnt()) {
            System.out.println(car.getName());
        }
    }
}
