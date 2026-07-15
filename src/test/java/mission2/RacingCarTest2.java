package mission2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest2 {
    @Test
    @DisplayName("레이킹카 리뉴얼 버전")
    void test_레이싱카(){
        String[] names = {"a", "b", "c"};
        int count = 5;
        Racing racing = new Racing(names,count);
        racing.start();
    }
}
