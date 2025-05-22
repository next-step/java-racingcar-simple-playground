package domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameParserTest {
    @Test
    @DisplayName("자동차 이름을 쉼표(,)를 기준으로 구분하고 String 리스트를 반환한다")
    void return_String_List_When_given_comma_and_names() {
        //Given
        String names = "빨,주,노,초,파,남,보";

        //When
        List<String> result = CarNameParser.nameParse(names);

        //Then
        assertThat(result).containsExactly("빨", "주", "노", "초", "파", "남", "보");
    }

    @Test
    @DisplayName("자동차 이름이 비워졌을 시 예외를 던진다")
    void exception_when_given_inputNames_empty() {
        //Given
        String names = "";

        //When & Then
        assertThatThrownBy(() -> CarNameParser.nameParse(names))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력값은 비워둘 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름에 빈 값이 포함될 경우 필터링 후 반환된다")
    void return_after_filtering_names() {
        //Given
        String names = ",,,,,,빨, , 주,  ,노,,,,초,,,";

        //When
        List<String> result = CarNameParser.nameParse(names);

        //Then
        assertThat(result).containsExactly("빨", "주", "노", "초");
    }

    @Test
    @DisplayName("자동차 이름 내부에 공백 포함될 경우 공백을 지워 반환한다")
    void return_after_removing_space_inner_names() {
        //Given
        String names = "강 아지,고 양이";

        //When
        List<String> result = CarNameParser.nameParse(names);

        //Then
        assertThat(result).containsExactly("강아지", "고양이");
    }
}
