package utils;

import domain.Car;

import java.util.*;

public class RacingGameTestUtil {

    private static final String DEFAULT_CAR_NAME = "CAR";
    private static final int LOOP_LIMIT = 100;

    private RacingGameTestUtil() {
    }

    public static boolean hasEqualElements(Object[] array1, Object[] array2) {
        if (!hasEqualLength(array1, array2)) {
            return false;
        }

        Set<Object> set1 = new HashSet<>(Arrays.asList(array1));
        Set<Object> set2 = new HashSet<>(Arrays.asList(array2));

        return set1.equals(set2);
    }

    public static List<Car> getCarsWithLongestMoveDistance(int longestMoveDistance) {
        List<Car> cars = new ArrayList<>();

        int hopeMoveDistance = longestMoveDistance;
        for (int i = 0; i < LOOP_LIMIT; i++) {
            if (isNotPositive(hopeMoveDistance)) {
                break;
            }

            Car car = Car.from(DEFAULT_CAR_NAME);
            setCarsMoveDistance(car, hopeMoveDistance);
            cars.add(car);

            hopeMoveDistance--;
        }

        return Collections.unmodifiableList(cars);
    }

    private static boolean hasEqualLength(Object[] array1, Object[] array2) {
        return array1.length == array2.length;
    }

    private static void setCarsMoveDistance(Car car, int hopeMoveDistance) {
        int requiredRepeatTime = hopeMoveDistance - 1;

        repeatGoForward(car, requiredRepeatTime);
    }

    private static void repeatGoForward(Car car, int repeatCount) {
        for (int i = 0; i < repeatCount; i++) {
            car.goForward();
        }
    }

    private static boolean isNotPositive(int number) {
        return number <= 0;
    }
}
