import java.util.*;

public class RacingcarGame {
    List<Car> carList = new ArrayList<>();

    // carList에 car를 넣는 메서드
    public void addCar(Car car) {
        carList.add(car);
    }

    /*
    * 우승 자동차 구하기
    * */
    public ArrayList<Car> getWinner() {
        ArrayList<Car> winners = new ArrayList<>();
        int max = compare();

        for(Car car : carList) {
            putWinner(max, car, winners);
        }

        return winners;
    }
    // 차 비교하기
    public int compare() {
        int max = 0;
        for(Car car : carList) {
            max = maxDistance(max, car);
        }
        return max;
    }

    // Car의 누적거리가 max보다 크면 max값 갱신
    public int maxDistance(int max, Car car) {
        if(max < car.getTotalDistance()) max = car.getTotalDistance();
        return max;
    }

    // max와 누적거리가 같은 Car를 winner에 담기
    public void putWinner(int max, Car car, ArrayList<Car> winners) {
        if(max == car.getTotalDistance()) winners.add(car);
    }


}
