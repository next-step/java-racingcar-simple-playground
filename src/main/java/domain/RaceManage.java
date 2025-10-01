package domain;

public class RaceManage {
    public void startRace(Cars cars, int rounds) {
        MoveCondition moveCondition = new MoveCondition();

        for (int round = 0; round < rounds; round++) {
            runRound(cars, moveCondition);
            printRoundResult(cars);
        }
        System.out.println();
    }

    private void runRound(Cars cars, MoveCondition moveCondition) {
        for (Car car : cars.getCars()) {
            int randomNumber = moveCondition.randomNumber();
            car.move(randomNumber);
        }
    }

    private void printRoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
