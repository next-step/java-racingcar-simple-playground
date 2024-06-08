import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.CustomGenerator;
import util.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("NumberGenerator Junit5 Test")
public class NumberGeneratorTest {
    @DisplayName("CustomGenerator generate Number Test")
    @Test
    public void customGenerateTest() {
        CustomGenerator generator = new CustomGenerator(5);
        assertThat(generator.generateNum()).isEqualTo(5);
    }


    @DisplayName("Generator range check Test : exception by out of range 0~9")
    @ParameterizedTest
    @ValueSource(ints = {20, 21, 11, -7, -1})
    public void generatorRangeCheckTest() {
        CustomGenerator generator = new CustomGenerator(20);
        assertThatThrownBy(() -> {
            generator.generateNum();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("RandomGenerator Test")
    @Test
    public void randomGeneratorTest() {
        RandomGenerator generator = new RandomGenerator();
        assertThat(generator.generateNum()).isBetween(0, 9);
    }
}
