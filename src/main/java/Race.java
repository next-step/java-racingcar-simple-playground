import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> Cars=new ArrayList<>();

    void initCars(String name){
        Cars.add(new Car(name));
    }
    //List는 인덱스로 접근 불가 !! 메서드이용할것.

    void start(NumberGenerator numberGenerator){
        int n=numberGenerator.generate();
        for (Car car : Cars) {
            car.Move(n);
        }
    }

    void getResult(){
        for (Car car : Cars) {
            System.out.println(car.getName()+": "+car.getDistance());
        }
    }

    //우승자구하기
    List<Car> getWinner() {
        getResult();

        int max = 0;
        List<Car> Winner = new ArrayList<>();
        for (Car car : Cars) {
            if (max <= car.getDistance())
                max = car.getDistance();
        }
        for (Car car : Cars) {
            if (car.getDistance() == max)
                Winner.add(car);
        }
        return Winner;
    }

}
