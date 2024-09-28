package racingcar.model;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CreateObjectCarsTest {
    @Test
    void 차_이름_문자열을_배열로_잘_저장하는_지_확인() {
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
    void 자동차_객체_생성_및_리스트에_저장이_되었는_지_확인() {
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
    void 글자수가_5자_이하일_때_글자수_제한_오류_발생_안_함() {
        //Given
        String carName = "carA";
        CreateObjectCars createObjectCars = new CreateObjectCars();

        //When & Then
        assertDoesNotThrow(() -> createObjectCars.carNameLengthLimit(carName));
    }

    @Test
    void 글자수가_n자_초과일_때_글자수_제한_오류_발생함() {
        //Given
        String carName = "carABC";
        CreateObjectCars createObjectCars = new CreateObjectCars();

        //When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> createObjectCars.carNameLengthLimit(carName));
        //Then
        assertEquals("자동차 이름은 5자 이하만 가능합니다. 프로그램을 종료합니다.", exception.getMessage());
    }
}
