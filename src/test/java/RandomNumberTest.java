import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class RandomNumberTest {

    @Test
    @DisplayName("난수 확인하기")
    void numberStatus() {
        Random random = new Random();

        int result = RandomNumber.numberStatus();

        assertThat(result).isEqualTo(4);
        // 랜덤 난수 확인


    }
}