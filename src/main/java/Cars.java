import NumberGenerator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        cars= new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void moveAll(NumberGenerator numberGenerator){
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    public void printAll(){
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    /**
     * 우승자 구하기
     */
    public List<Car> getWinner() {
        int max = getMax();

        return cars.stream()
                   .filter(car -> car.getDistance()==max)
                   .toList();
    }

    /**
     * 최대 거리 구하기
     */

    private int getMax() {

        return cars.stream()
                   .mapToInt(Car::getDistance)
                   .max()
                   .orElse(0);
    }

}
