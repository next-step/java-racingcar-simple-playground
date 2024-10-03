package domain.car;

import java.util.Arrays;
import java.util.List;

public class CarMapper {

    private final static String SEPATATOR = ",";

    public static Cars transformCarsNameListToCars(String carsNameInput) {

        List<String> carsNameList = Arrays.stream(carsNameInput.split(SEPATATOR)).toList();
        List<Car> carList = carsNameList.stream().map(Car::new).toList();

        return new Cars(carList);

    }
}
