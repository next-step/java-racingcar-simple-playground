package utils;

import dto.CarProgressDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarProgressFormatterTest {

    @Test
    @DisplayName("CarProgressDto를 형식 문자열로 변환한다")
    void formatDtoToString() {
        CarProgressDto dto = new CarProgressDto("neo", 3);

        String formatted = CarProgressFormatter.format(dto);

        assertThat(formatted).isEqualTo("neo : ---");
    }
}
