import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class RandomNumberTest {

    @Test
    @DisplayName("랜덤 클래스를 활용한 고정된 시드에서 난수 확인하기")
    void fixSeed() {
        RandomNumber randomNumber = new RandomNumber(10); // 시드 고정 10 -> 1로 나옴
        int result = randomNumber.instanceNumber();
        assertThat(result).isEqualTo(1);
    }
}