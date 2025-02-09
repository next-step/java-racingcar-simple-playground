package domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

import objectTmp.Car;

public class RacingGame {
    private static Car[] cars;
    private static int times;
    private static int[] locate;
    
    public RacingGame(String[] carNames, int times){
        if (times <= 0){
            throw new IllegalArgumentException();
        }

        for (String name : carNames){
            if (name.length() > 5 || name.isEmpty()){
                throw new IllegalArgumentException();
            }
        }

        cars = Arrays.stream(carNames)
                    .map(Car::new)
                    .toArray(Car[]::new);
        
        RacingGame.times = times;
    }

    public static void race(){
        for (int i = 0; i < times; ++i){
            print(locate);
            for (int r = 0; r < cars.length; ++r){
                locate[r] += cars[r].move();
            }
            System.out.println();
        }
    }

    public static void print(int[] locate){
        for (int i = 0; i < cars.length; ++i){
            System.out.println(cars[i].getName() + " : " + locate[i]);
        }
    }

    public static Car[] getWinners(){
        int max = Arrays.stream(locate)
            .max()
            .getAsInt();

        return IntStream.range(0, cars.length)
                        .filter(i -> locate[i] == max)
                        .mapToObj(i -> cars[i])
                        .toArray(Car[]::new);
    }
    
    public static int[] getLocate(){
        return locate;
    }
    
}
