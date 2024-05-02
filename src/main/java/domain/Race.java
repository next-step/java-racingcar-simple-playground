package domain;

import view.Print;

import java.util.ArrayList;

public class Race {

    public ArrayList<Car> initCar(String[] nameList) {

        ArrayList<Car> carList = new ArrayList<>();

        for (int i = 0; i < nameList.length; i++) {
            Car car = new Car();
            carList.add(car);
            carList.get(i).name = nameList[i];
        }

        return carList;
    }

    public ArrayList<Car> startRace(ArrayList<Car> carList) {
        Car car = new Car();
        Race race = new Race();

        // 전체 횟수 반복추가
        for (int i = 0; i < carList.size(); i++) {
            car.check(race.getRandNum(), carList.get(i));
        }

        return carList;
    }


    public int getMaxNumber(Car car, int max, int index, int i) {

        if (car.getCurrentLocation() > max) {
            return i;
        }

        return index;
    }

    public ArrayList<String> getWinner(ArrayList<Car> carList) {
        int max = carList.get(0).getCurrentLocation();
        int index = 0;

        for (int i = 0; i < carList.size(); i++) {
            index = getMaxNumber(carList.get(i), max, index, i);
        }

        // 중복 우승자 구하기
        ArrayList<String> winners = new ArrayList<>();
        max = carList.get(index).getCurrentLocation();

        for (int i = 0; i < carList.size(); i++) {
            checkWinnersInArray(carList, winners, max, i);
        }

        return winners;
    }

    public void checkWinnersInArray(ArrayList<Car> carList, ArrayList<String> winners, int max, int i) {
        if (checkDuplication(carList, max, i) != -1) {
            winners.add(carList.get(checkDuplication(carList, max, i)).getName());
        }
    }

    public int checkDuplication(ArrayList<Car> carList, int max, int i) {
        if (carList.get(i).getCurrentLocation() == max) {
            return i;
        }

        return -1;
    }

    public int getRandNum() {
        double ran = Math.random();
        return (int) (ran * 10);
    }
}
