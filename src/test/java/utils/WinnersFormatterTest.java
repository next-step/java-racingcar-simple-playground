package utils;

import dto.WinnersDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersFormatterTest {

    @Test
    @DisplayName("WinnersDto를 우승자 출력 문자열로 포맷한다")
    void formatWinnersDto() {
        WinnersDto dto = new WinnersDto(List.of("neo", "brie"));

        String result = WinnersFormatter.format(dto);

        assertThat(result).isEqualTo("neo, brie가 최종 우승했습니다.");
    }
}
