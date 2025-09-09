import java.util.ArrayList;
import java.util.List;

public class Race {
    public int carCount;
    public int raceTurn;

    public List<Car>generateCars(int carCount){
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < carCount; i++){
            Car car = new Car("Car No." +  i, 0);
            cars.add(car);
        }
        return cars;
    }

    public void initRace(List<Car> cars){
        for(Car car : cars){
            car.carLocation = 0;
        }
    }

    public void PlaySingleTurn(List<Car> cars){
        for(Car car : cars){
            int randomDigit = new RandomDigitGenerator().generateRandomDigit();
            car.move(randomDigit);
        }
    }

    public void getWinner(List<Car> cars){
        List<Car> winners = new ArrayList<>();

    }

    public void PlayRace(List<Car> cars , int raceTurn){
        initRace(cars);
        for(int i=0;i<raceTurn;i++){
            PlaySingleTurn(cars);
        }

    }

    public Race(int carCount, int raceTurn) {
        this.carCount = carCount;
        this.raceTurn = raceTurn;
    }
}
