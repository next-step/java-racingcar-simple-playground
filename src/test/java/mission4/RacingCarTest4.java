package mission4;

import mission2.Racing;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarTest4 {
    @Test
    @DisplayName("랜덤한 수의 범위를 9로 고정해서 항상 이동하는 거리가 같도록한다. 결과적으로 a,b,c가 이동하는 거리가 동일하다.")
    void test_고정된_범위로_테스트(){
        String[] names = {"a", "b", "c"};
        int count = 5;
        Racing racing = new Racing(names,count,new FixedNum(9));
        racing.start();
        assertEquals(List.of("a", "b", "c"),racing.getWinners());
    }
}
