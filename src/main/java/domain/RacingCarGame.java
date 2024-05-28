package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import util.NumberGenerator;

public class RacingCarGame {
    private List<RacingCar> cars;
    private HashSet<RacingCar> winners;
    private int winnersPosition;
    private int times;
    private NumberGenerator numberGenerator;

    public RacingCarGame(String[] names, int times, NumberGenerator numberGenerator){
        this.cars = new ArrayList<>();
        this.winners = new HashSet<>();
        this.winnersPosition = 0;
        this.times = times;
        for(String name : names){
            cars.add(new RacingCar(name, numberGenerator));
        }
    }

    public void playTurn(){
        if(cars.isEmpty()) {
            throw new RuntimeException("게임에 참여하는 자동차는 1대 이상이어야 합니다.");
        }
        for(RacingCar car : cars){
            car.move();
            validateIsWinner(car);
        }
    }

    private void validateIsWinner(RacingCar car){
        if(winnersPosition > car.getPosition()){
            return;
        }
        if(winnersPosition == car.getPosition()){
            winners.add(car);
            return;
        }
        if(winnersPosition < car.getPosition()){
            winners.clear();
            winnersPosition++;
            winners.add(car);
        }
    }

    public List<String> getWinners(){
        return winners.stream().map(RacingCar::getName).collect(Collectors.toList());
    }

    public int getWinnersPosition(){
        return winnersPosition;
    }

    public List<RacingCar> getRacingCars() {
        return cars;
    }

    public int getTimes() {
        return times;
    }
}
