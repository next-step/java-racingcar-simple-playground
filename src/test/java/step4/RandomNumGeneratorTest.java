package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.utils.RandomNumGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumGeneratorTest {
    @Test
    @DisplayName("random 값은 0에서 9사이에 값이 반환된다")
    void randNumIsBetweenZeroAndNine(){
        //given,when
        int randomNum = RandomNumGenerator.getRandomNum();

        //then
        assertThat(randomNum).isBetween(0,9);
    }

}
