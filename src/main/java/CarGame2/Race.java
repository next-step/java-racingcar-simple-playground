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
        winCar();

    }
    private void playRound(int curRound) {
        System.out.println("ROUND "+curRound);
        for(Car car:cars) {
            int prevPosition = car.getPosition();
            car.move();
            int newPosition = car.getPosition();
            System.out.println(car.getCarNum() + "번 자동차 이동 거리: " + (newPosition - prevPosition) + " (현재위치: " + newPosition+")" );
        }
    }
    private void winCar() {
        int maxPosition = getMaxPosition();
        System.out.print("우승한 자동차: ");
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPosition() == maxPosition) {
                System.out.print((i + 1) + " ");
            }
        }
    }
    private int getMaxPosition() {
        int maxPosition = 0;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPosition() > maxPosition) {
                maxPosition = cars.get(i).getPosition();
            }
        }
        return maxPosition;
    }
}


