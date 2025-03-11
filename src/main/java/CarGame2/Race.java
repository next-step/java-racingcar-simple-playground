package CarGame2;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars=new ArrayList<>();
    private int rounds;
    public Race(int carCount,int rounds){
        this.rounds=rounds;
        createCars(carCount);
    }
    private void createCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
            cars.get(i).setCarNum(i+1);
        }
    }
    public void startRace(){
        for(int i=0;i<rounds;i++){
            playRound(i+1);
        }
        printWinners();

    }
    private void playRound(int curRound) {
        System.out.println("ROUND "+curRound);
        for(Car car:cars) {
            moveCar(car);
            printCarStatus(car);
        }
        System.out.println("-------------------");
    }
    private void moveCar(Car car) {
        car.move();
    }
    private void printCarStatus(Car car) {
        int position = car.getPosition();
        System.out.println(car.getCarNum() + "번 자동차 이동거리: "+car.getSpeed()+" [현재 위치: " + position+"]");
    }
    private void printWinners() {
        int maxPosition=getMaxPosition();
        List<Integer> winners=findWinners(maxPosition);
        System.out.print("우승한 자동차: ");
        for(int winner:winners){
            System.out.print(winner+"번 ");
        }

    }
    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = getHigherPosition(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
    private int getHigherPosition(int currentMax, int newPosition) {
        if (newPosition > currentMax) {
            return newPosition;
        }
        return currentMax;
    }

    private List<Integer> findWinners(int maxPosition) {
        List<Integer> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinner(winners, car, maxPosition);
        }
        return winners;
    }
    private void addWinner(List<Integer> winners, Car car, int maxPosition) {
        if (isWinner(car, maxPosition)) {
            winners.add(car.getCarNum());
        }
    }
    private boolean isWinner(Car car, int maxPosition) {
        return car.getPosition() == maxPosition;
    }


}


