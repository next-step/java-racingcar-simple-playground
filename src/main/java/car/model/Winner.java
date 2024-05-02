package car.model;

import java.util.List;

public class Winner {
    public String winnerCars;

    public void findWinner(RacingCars racingCars){
        List<Car> cars = racingCars.getCars();
        int max = 0;
        String winner = "";
        for (Car car : cars) {
            if(car.getPosition() >max){
                max = car.getPosition();
                winner = car.getName();
            }
            else if(max == car.getPosition()){
                winner += ", " + car.getName();
            }
        }
        racingCars.setWinner(winner);
        this.winnerCars = winner;
    }

}
