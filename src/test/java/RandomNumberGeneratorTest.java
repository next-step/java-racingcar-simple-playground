import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("생성된 랜덤 값이 0에서 9 사이의 범위인지 확인한다.")
    void 범위_내의_랜덤값_생성_테스트() {
        NumberGenerator generator = new RandomNumberGenerator();

        for (int i = 0; i < 1000; i++) {
            int randomNumber = generator.generate();
            assertThat(randomNumber).isBetween(0, 9);
        }
    }
}