package dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarProgressDtoTest {

    @Test
    @DisplayName("toDisplayString(): 이름과 위치를 포맷된 문자열로 반환한다")
    void toDisplayString() {
        CarProgressDto dto = new CarProgressDto("neo", 3);

        assertThat(dto.toDisplayString()).isEqualTo("neo : ---");
    }
}
