import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 테스트 클래스당 인스턴스 하나만 생성해서 모든 테스트 메서드에서 공유
public class SimpleTest {

   int value = 1;

    @Test
    void test1() {
        value++;

        assertThat(value).isEqualTo(2);
    }

    @Test
    void test2() {
        value--;

        assertThat(value).isEqualTo(0);
    }
}