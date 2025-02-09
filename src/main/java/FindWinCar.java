import java.util.Objects;
import java.util.stream.IntStream;
import java.util.Arrays;

public class FindWinCar {
    Car[] cars;
    int[] locate;

    public FindWinCar(int n, Car[] car){
        if (n <= 0){
            throw new IllegalArgumentException();
        }

        this.cars = Objects.requireNonNull(car);
        this.locate = new int[n];
    }

    public void allMove(int times){
        if (times < 0){
            throw new IllegalArgumentException();
        }

        for (int t = 0; t < times; ++t){
            move();
        }
    }

    public void move(){
        for (int r = 0; r < cars.length; ++r){
            locate[r] += cars[r].move();
        }
    }

    public Car[] findWin(){
        int max = Arrays.stream(locate)
                        .max()
                        .getAsInt();

        return IntStream.range(0, cars.length)
                        .filter(i -> locate[i] == max)
                        .mapToObj(i -> cars[i])
                        .toArray(Car[]::new);
    }

    public int[] getLocate(){
        return locate;
    }

    public Car[] getCars(){
        return cars;
    }

}
