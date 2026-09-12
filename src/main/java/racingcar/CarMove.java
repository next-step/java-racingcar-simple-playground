package racingcar;

public class CarMove {


    public void move(Cars cars, RandomNumber randomNumber) {
        for (int i = 0; i < cars.size(); i++) {
            int number = randomNumber.getRandomNumber();
            cars.getCars().get(i).movePoint(number);
        }
    }


    public void carRace(Cars cars, RandomNumber randomNumber, int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            move(cars, randomNumber);
        }
    }

}
