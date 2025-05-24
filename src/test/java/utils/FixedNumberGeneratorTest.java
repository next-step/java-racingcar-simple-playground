package utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("고정 수 생성 테스트")
public class FixedNumberGeneratorTest {

    @Test
    @DisplayName("고정된 숫자 생성 확인")
    void fixedNumberGenerator() {
        FixedNumberGenerator generator = new FixedNumberGenerator(7);
        assertThat(generator.generate()).isEqualTo(7);
    }

}

