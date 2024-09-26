package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomGeneratorTest {
    @Test
    @DisplayName("랜덤 숫자 범위 테스트")
    void getRandomNumberTest(){
        RandomGenerator randomGenerator = new RandomGenerator();
        int num = randomGenerator.getRandomNumber();
        Assertions.assertThat(num).isBetween(0,10);
    }

}