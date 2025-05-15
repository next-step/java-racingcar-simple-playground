import domain.CarName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    @Test
    @DisplayName("5자를 초과하면 예와가 발생 한다.")
    void throwsInvalidLengthUserNameException() {
        assertThatThrownBy(() -> new CarName("123456")).isInstanceOf(CarName.InvalidLengthCarNameException.class);
    }

    @ParameterizedTest(name = "입력값: \"{0}\" → IllegalArgumentException 발생")
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    void throwsIllegalArgumentException(String carName) {
        assertThatThrownBy(() -> new CarName(carName)).isInstanceOf(IllegalArgumentException.class);
    }
}
