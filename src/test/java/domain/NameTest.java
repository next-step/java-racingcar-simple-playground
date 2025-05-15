package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @Test
        @DisplayName("값이 같은 Name은 동등하다")
        void equalWhenSameValue() {
            Name name1 = new Name("사이다");
            Name name2 = new Name("사이다");

            Assertions.assertThat(name1).isEqualTo(name2);
            Assertions.assertThat(name1).isNotSameAs(name2);
            Assertions.assertThat(name1.getValue()).isEqualTo("사이다");
        }

        @Test
        @DisplayName("동등한 Name은 hashCode도 동일하다")
        void hashCodeShouldMatchIfEqual() {
            Name a = new Name("물");
            Name b = new Name("물");

            Assertions.assertThat(a).isEqualTo(b);
            Assertions.assertThat(a.hashCode()).isEqualTo(b.hashCode());
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {

        @Test
        @DisplayName("null 값으로 Name을 생성하면 예외가 발생한다")
        void throwWhenNull() {
            assertThatThrownBy(() -> new Name(null))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 이름은 비어 있을 수 없습니다.");
        }

        @Test
        @DisplayName("빈 문자열로 Name을 생성하면 예외가 발생한다")
        void throwWhenEmpty() {
            assertThatThrownBy(() -> new Name(""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 이름은 비어 있을 수 없습니다.");
        }

        @Test
        @DisplayName("공백 문자열로 Name을 생성하면 예외가 발생한다")
        void throwWhenBlank() {
            assertThatThrownBy(() -> new Name("   "))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 이름은 비어 있을 수 없습니다.");
        }
    }
}
