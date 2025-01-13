import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.CarNamesStringValidator;

import java.util.Arrays;
import java.util.List;

import static model.Car.MAX_CAR_NAME_LENGTH;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNamesStringValidatorTest {
    @Test
    @DisplayName("자동차 이름이 하나도 입력되지 않았을 경우 해당 에러를 설명하는 예외를 발생시켜야 한다.")
    void should_ThrowError_IfInputIsBlank() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CarNamesStringValidator.validate(List.of());
        }).withMessage("자동차의 이름을 하나 이상 입력해 주세요.");
    }

    @Test
    @DisplayName("자동차 이름 입력값이 비어 있을 경우 해당 에러를 설명하는 예외를 발생시켜야 한다.")
    void should_ThrowError_IfCarLengthIsBlank() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CarNamesStringValidator.validate((Arrays.asList("a", "   ", "b")));
        }).withMessage("자동차의 이름은 비어 있어서는 안 됩니다.");
    }

    @Test
    @DisplayName("자동차의 이름이 정해진 제한 글자를 넘었을 경우 해당 에러를 설명하는 예외를 발생시켜야 한다.")
    void should_ThrowError_IfCarLengthExceededAllowedLength() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CarNamesStringValidator.validate((List.of("myNameIsTooLong")));
        }).withMessage("자동차의 이름의 길이는 " + MAX_CAR_NAME_LENGTH + "자를 넘어서는 안 됩니다.");
    }

    @Test
    @DisplayName("같은 이름의 자동차가 여러 대 존재할 경우 해당 에러를 설명하는 예외를 발생시켜야 한다.")
    void should_ThrowError_IfCarNameDuplicates() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CarNamesStringValidator.validate((Arrays.asList("빨강", "파랑", "빨강", "노랑")));
        }).withMessage("자동차의 이름은 중복될 수 없습니다.");
    }
}
