import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GoStopValidatorTest {

    @Test
    @DisplayName("랜덤 값이 4이상이면 true(전진), 3이하이면 false(멈춤)를 반환한다.")
    public void checkGoOrStop() {
        //given
        final int randomValue = RandomValueCreator.createRandomValue();

        //when, then
        System.out.println("randomValue = " + randomValue);
        boolean result = GoOrStopValidator.validateGoOrStop(randomValue);

        //Assumptions.assumingThat(condition, lambda) : 조건식이 참일 때 람다 식 안의 테스트 실행
        Assumptions.assumingThat(randomValue >= 4, () -> {
            Assertions.assertThat(result).isEqualTo(true);
        });

        Assumptions.assumingThat(randomValue <= 3, () -> {
            Assertions.assertThat(result).isEqualTo(false);
        });
    }
}
