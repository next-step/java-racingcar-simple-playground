import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.CarNamesStringValidator;
import validator.RoundCountValidator;

import java.util.Arrays;
import java.util.List;

import static model.Car.MAX_CAR_NAME_LENGTH;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoundCountValidatorTest {
    @Test
    @DisplayName("라운드 수가 유효하지 않을 경우 해당 에러를 설명하는 예외를 발생시켜야 한다.")
    void should_ThrowError_UnknownRoundCount() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RoundCountValidator.validate(0);
        }).withMessage("시도 횟수는 1회 이상으로 입력해 주세요.");
    }
}
