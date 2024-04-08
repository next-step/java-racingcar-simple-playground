import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import utils.RandomNumberGenerator;

import java.util.List;

/*
* 오류로 인해 build가 되지 않는 상태입니다.
* 그래서 test 코드를 실행하고 있지 못하여 일단은 코드만 작성하였습니다.
* */

public class JUnit5Test {

    @Nested
    @DisplayName("generate 메서드 0~9 정수 반환 테스트")
    class GenerateMethodTest{
        @Test
        @DisplayName("generate 메서드는 0에서 9사이의 정수를 반환한다.")
        void testGenerateMethodReturnZeroAndNine(){
            List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
            int testNumber = RandomNumberGenerator.generate();
            if(!numbers.contains(testNumber)){
                throw new RuntimeException("generate 메소드가 0에서 9사이의 정수를 반환하지 않습니다.");
            }
        }
    }
}