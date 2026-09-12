import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> cars=new ArrayList<>();

    void initCars(String name){
        cars.add(new Car(name));
    }
    //List는 인덱스로 접근 불가 !! 메서드이용할것.

    void start(NumberGenerator numberGenerator){
        int n=numberGenerator.generate();
        for (Car car : cars) {
            car.Move(n);
        }
    }

    void getResult(){
        for (Car car : cars) {
            System.out.println(car.getName()+": "+car.getDistance());
        }
    }

    //우승자구하기
    List<Car> getWinner() {
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
