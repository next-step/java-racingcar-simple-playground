package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.DisplayName;
public class RandomNumberGeneratorTest {
    @DisplayName("0~9까지만나온다")
    @RepeatedTest(100)
    void generateTest() {
        NumberGenerator numberGenerator=new RandomNumberGenerator();

        int number=numberGenerator.generate();
        assertThat(number).isBetween(0,9);
    }
}
