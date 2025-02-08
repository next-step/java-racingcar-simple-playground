import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing
{
    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car curCar)
    {
        cars.add(curCar);
    }

    public void startRace(int raceCount)
    {
        for (int i=0; i<raceCount; i++)
            cars.forEach(Car::MoveCar);
    }

    private int findMaxPos()
    {
        return cars.stream()
                .mapToInt(Car::getCarPos)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("There is no car."));
    }

    public List<String> findWinner()
    {
        return cars.stream()
                .filter(car -> car.getCarPos() == findMaxPos())
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }
}
