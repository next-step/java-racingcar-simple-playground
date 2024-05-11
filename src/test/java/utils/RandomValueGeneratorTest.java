package utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomValueGeneratorTest {

    /**
     * 질문 : 이미 구현되어 있는 라이브러리 또는 메서드에 대한 테스트도 작성을 해야 되는건가요? (페어 프로그래밍 질문)
     * ex) java.util 패키지에 있는 메서드가 제대로 동작하는지를 테스트를 직접 만들어야 될 필요가 있는지
     */
    @Test
    @DisplayName("0부터 9까지 랜덤 숫자를 생성하는지 확인한다.")
    void generateZeroToNineTest() {
        ValueGenerator generator = new RandomValueGenerator();
        int value = generator.generate();
        assertThat(value).isBetween(0, 9);
    }

}
