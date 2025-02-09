import java.util.Objects;
import java.util.stream.IntStream;
import java.util.Arrays;

public class FindWinCar {
    Car[] car;
    int[] locate;

    public FindWinCar(int n, Car[] car){
        if (n <= 0){
            throw new IllegalArgumentException();
        }

        this.car = Objects.requireNonNull(car);
        this.locate = new int[n];
    }

    public void move(){
        for (int r = 0; r < car.length; ++r){
            locate[r] += car[r].move();
        }
    }

    public Car[] findWin(){
        int max = Arrays.stream(locate)
                        .max()
                        .getAsInt();

        return IntStream.range(0, car.length)
                        .filter(i -> locate[i] == max)
                        .mapToObj(i -> car[i])
                        .toArray(Car[]::new);
    }

}
