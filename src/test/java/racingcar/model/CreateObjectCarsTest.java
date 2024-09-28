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

    @Test
    @DisplayName("글자수가 5자 이하일 때 글자수 제한 오류 발생 여부")
    void NonNameLenghtError() {
        //Given
        String carName = "carA";
        CreateObjectCars createObjectCars = new CreateObjectCars();

        //When & Then
        assertDoesNotThrow(() -> createObjectCars.carNameLengthLimit(carName));
    }

    @Test
    @DisplayName("글자수가 n자 초과일 때 글자수 제한 오류 발생 여부")
    void nameLenghtError() {
        //Given
        String carName = "carABC";
        CreateObjectCars createObjectCars = new CreateObjectCars();

        //When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> createObjectCars.carNameLengthLimit(carName));
        //Then
        assertEquals("자동차 이름은 5자 이하만 가능합니다. 프로그램을 종료합니다.", exception.getMessage());
    }
}
