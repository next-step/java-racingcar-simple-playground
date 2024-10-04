package racingcar.model;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class CreateObjectCarsTest {
    @Test
    void 차_이름_문자열을_배열로_잘_저장하는_지_확인() {
        //Given
        CreateObjectCars createObjectCars = new CreateObjectCars();
        String carNamesStr = "CarA,CarB,CarC";

        //When
        String[] carNamesArr = createObjectCars.splitCarNames(carNamesStr);

        //Then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(carNamesArr.length).isEqualTo(3);
            softly.assertThat(carNamesArr[0]).isEqualTo("CarA");
            softly.assertThat(carNamesArr[1]).isEqualTo("CarB");
            softly.assertThat(carNamesArr[2]).isEqualTo("CarC");
        });

    }

    @Test
    void 자동차_객체_생성_및_리스트에_저장이_되었는_지_확인() {
        //Given
        CreateObjectCars createObjectCars = new CreateObjectCars();
        String[] carNamesArr = {"CarA", "CarB", "CarC"};

        //When
        List<Car> carList = createObjectCars.createCarList(carNamesArr);

        //Then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(carNamesArr.length).isEqualTo(3);
            softly.assertThat(carNamesArr[0]).isEqualTo("CarA");
            softly.assertThat(carNamesArr[1]).isEqualTo("CarB");
            softly.assertThat(carNamesArr[2]).isEqualTo("CarC");
        });
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
        Assertions.assertThatThrownBy(() -> createObjectCars.carNameLengthLimit(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다. 프로그램을 종료합니다.");
    }
}
