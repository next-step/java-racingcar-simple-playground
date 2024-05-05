package domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private HashSet<RacingCar> cars;
    private HashSet<RacingCar> winners;
    private int winnersPosition;

    public RacingCarGame(){
        cars = new HashSet<>();
        winners = new HashSet<>();
        winnersPosition = 0;
    }

    public void addCar(String name){
        cars.add(new RacingCar(name));
    }

    public void playTurn(){
        if(cars.isEmpty()) {
            throw new RuntimeException();
        }
        for(RacingCar car : cars){
            car.move();
            validate(car);
        }
    }

    private void validate(RacingCar car){
        if(winnersPosition > car.getPosition()){
            return;
        }
        if(winnersPosition == car.getPosition()){
            winners.add(car);
            return;
        }
        if(winnersPosition < car.getPosition()){
            winners.clear();
            winners.add(car);
        }
    }

    public List<String> getWinners(){
        return winners.stream().map(RacingCar::getName).collect(Collectors.toList());
    }

    public int getWinnersPosition(){
        return winnersPosition;
    }
}
