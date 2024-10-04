import domain.RandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomNumTest {

    @DisplayName("랜덤 숫자 범위 테스트")
    @Test
    void testRandomNumberWithinRange(){
        int randomNum = RandomGenerator.getRandomNumber();

        assertTrue(randomNum>=0&&randomNum<10);
    }
}
