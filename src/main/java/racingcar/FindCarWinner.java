package racingcar;

import java.util.ArrayList;
import java.util.List;

public class FindCarWinner {


    public List<Car> findWinner(Cars cars) {
        //최대위치인 차만 고르면됨
        int maxPosition = getMaxPosition(cars);
        List<Car> winners = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            addWinnerIfMatch(cars.getCars().get(i).getCarPosition(), maxPosition, winners, cars, i);
        }
        return winners;
    }

    private void addWinnerIfMatch(int CarPosition, int maxPosition, List<Car> winners, Cars cars, int i) {
        if (CarPosition == maxPosition) {
            winners.add(cars.getCars().get(i));
        }
    }

    private int getMaxPosition(Cars cars) {//다른데서 쓸일 없으니까 여기서만 쓰니까 private
        int maxPosition = 0;
        for (int i = 0; i < cars.size(); i++) { //이게 최대위치 구한거
            maxPosition = compareMax(maxPosition, cars.getCars().get(i).getCarPosition());
        }
        return maxPosition;
    }

    private int compareMax(int maxPosition, int carPosition) {
        if (maxPosition < carPosition) {
            return carPosition;
        }
        return maxPosition;
    }


}