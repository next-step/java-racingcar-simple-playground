package domain;

import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private List<Car> cars;
    private int raceCnt;
    private List <String> winners;
    ResultView resultView;

    public RacingGame(List<Car> cars, int raceCnt) {
        this(cars, raceCnt, null);
    }

    public RacingGame(List<Car> cars, int raceCnt, ResultView resultView) { //super 그거 활용
        this.raceCnt = raceCnt;
        this.cars = cars;
        this.winners = new ArrayList<>();
        this.resultView = resultView;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getRaceCnt() {
        return raceCnt;
    }

    public void race(){

        resultView.printString();

        for (int i = 0; i < raceCnt; i++) {

            playOneRoundRace();

            resultView.printOneRoundResult(cars);
        }
    }

    public void playOneRoundRace() {

        for (Car car : cars) {
            int randomNum = createRandomNum();

            if (randomNum >= 4){
                car.forward();
            }
        }
    }

    private int createRandomNum() {
        return (int)(Math.random()*9);
    }

    public String getWinners() {

        int maxPosition = getMaxPosition();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition){
                this.winners.add(car.getCarName());
            }
        }

        return RemakeToFinalStringForm();
    }

    public int getMaxPosition() {

        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(),maxPosition);
        }

        return maxPosition;
    }

    private String RemakeToFinalStringForm() {
        return this.winners.stream().collect(Collectors.joining(","));
    }

}
