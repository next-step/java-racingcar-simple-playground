package domain;
import java.util.List;

public class WinnerFinder {

    public StringBuilder findWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        return buildWinnerNames(cars, maxPosition);
    }

    private int findMaxPosition(List<Car> cars){
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private StringBuilder buildWinnerNames(List<Car> cars, int maxPosition) {
        StringBuilder winnerNames = new StringBuilder();
        for(Car car : cars){
            appendWinnerName(car, maxPosition, winnerNames);
        }
        return winnerNames;
    }

    private void appendWinnerName(Car car, int maxPosition, StringBuilder winnerNames){
        if(car.getPosition() != maxPosition) {
            return;
        }
        if(!winnerNames.isEmpty()){
            winnerNames.append(", ");
        }
        winnerNames.append(car.getName());
    }
}
