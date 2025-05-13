package racingcar.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ApplicationError;
import racingcar.exception.ApplicationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "benz", "bmw", "hyun", "car2"})
    @DisplayName("이름 생성 테스트")
    void createName(String name) {
        final Name nameVo = new Name(name);

        assertThat(nameVo.value()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa", "bbbbbbbbbb", "123123123"})
    @DisplayName("이름 생성 실패 테스트 - 글자수 초과")
    void createNameFailLengthOverFive(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(ApplicationException.class)
                .hasMessage(ApplicationError.INVALID_NAME_TOO_LONG.getDescription());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "\t", "\n"})
    @DisplayName("이름 생성 실패 테스트 - 빈 문자열 또는 공백 문자열")
    void createNameFailEmptyOrWhitespaceString(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(ApplicationException.class)
                .hasMessage(ApplicationError.INVALID_NAME_EMPTY.getDescription());
    }

    @NullSource
    @DisplayName("이름 생성 실패 테스트 - null 값")
    void createNameFailNullValue(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(ApplicationException.class)
                .hasMessage(ApplicationError.INVALID_NAME_EMPTY.getDescription());
    }

    @Test
    @DisplayName("동일한 값을 가진 Name 객체는 equals에서 true를 반환해야 한다")
    void equalsShouldReturnTrueForSameValue() {
        Name name1 = new Name("car1");
        Name name2 = new Name("car1");

        assertThat(name1).isEqualTo(name2);
        assertThat(name1.hashCode()).isEqualTo(name2.hashCode());
    }

    @Test
    @DisplayName("다른 값을 가진 Name 객체는 equals에서 false를 반환해야 한다")
    void equalsShouldReturnFalseForDifferentValue() {
        Name name1 = new Name("car1");
        Name name2 = new Name("car2");

        assertThat(name1).isNotEqualTo(name2);
    }

    @Test
    @DisplayName("앞뒤 공백이 있는 이름은 trim 처리되는지 확인")
    void trimmedNameShouldBeValid() {
        String nameWithSpaces = " car1 ";

        Name name = new Name(nameWithSpaces);

        assertThat(name.value()).isEqualTo(nameWithSpaces);
    }
}