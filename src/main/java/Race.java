import NumberGenerator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> cars=new ArrayList<>();

    public void initCars(String name){
        cars.add(new Car(name));
    }

    public void start(NumberGenerator numberGenerator){
        for (Car car : cars) {
            int n=numberGenerator.generate();
            car.move(n);
        }
    }

    private void getResult(){
        for (Car car : cars) {
            System.out.println(car.getName()+": "+car.getDistance());
        }
    }

    /**
     * 우승자 구하기
     */
    public List<Car> getWinner() {
        getResult();

        List<Car> winners = new ArrayList<>();
        int max = getMax();
        for (Car car : cars) {
            if (car.getDistance() == max)
                winners.add(car);
        }
        return winners;
    }

    private int getMax() {
        int max= 0;
        for (Car car : cars) {
            if (max <= car.getDistance())
                max = car.getDistance();
        }
        return max;
    }

}
