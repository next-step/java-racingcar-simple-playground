package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CreateObjectCarsTest {
    @Test
    @DisplayName("차 이름 문자열을 배열로 잘 저장하는 지 확인")
    void TestSplitCarNames() {
        //Given
        CreateObjectCars createObjectCars = new CreateObjectCars();
        String carNamesStr = "CarA,CarB,CarC";

        //When
        String[] carNamesArr = createObjectCars.splitCarNames(carNamesStr);

        //Then
        assertEquals(3, carNamesArr.length);
        assertEquals("CarA", carNamesArr[0]);
        assertEquals("CarB", carNamesArr[1]);
        assertEquals("CarC", carNamesArr[2]);
    }

    @Test
    @DisplayName("자동차 객체 생성 및 리스트에 저장이 되었는 지 확인")
    void TestCreateCarList() {
        //Given
        CreateObjectCars createObjectCars = new CreateObjectCars();
        String[] carNamesArr = {"CarA", "CarB", "CarC"};

        //When
        List<Car> carList = createObjectCars.createCarList(carNamesArr);

        //Then
        assertEquals(3, carNamesArr.length);
        assertEquals("CarA", carNamesArr[0]);
        assertEquals("CarB", carNamesArr[1]);
        assertEquals("CarC", carNamesArr[2]);
    }
}
