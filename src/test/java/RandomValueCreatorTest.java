import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomValueCreator;

public class RandomValueCreatorTest {

    @Test
    @DisplayName("0~9사이의 랜덤값을 얻을 수 있다")
    public void getRandomValue0to9() {
        //given
        final int maxValue = 9;
        final int minValue = 0;

        //when
        final int result = RandomValueCreator.createRandomValue();
        System.out.println("result = " + result);

        //then
        Assertions.assertTrue(result <= maxValue);
        Assertions.assertTrue(result >= minValue);
    }
}
