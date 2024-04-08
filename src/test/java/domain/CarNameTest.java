package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayName("자동차 이름 테스트")
class CarNameTest {

    @Test
    void 자동차_이름_생성() {
        // given
        final String carName = "코코닥";

        // when & then
        assertThatCode(() -> CarName.from(carName)).doesNotThrowAnyException();
    }

    @Test
    void 자동차_이름의_길이가_5보다_크면_생성에_실패한다() {
        // given
        final String carName = "A".repeat(6);

        // when & then
        assertThatThrownBy(() -> CarName.from(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    void 자동차_이름은_공백일_수_없다() {
        // given
        final String carName = "  ";

        // when & then
        assertThatThrownBy(() -> CarName.from(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 공백일 수 없습니다.");
    }
}
