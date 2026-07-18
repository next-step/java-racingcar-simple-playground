package mission2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarTest2 {
    @Test
    @DisplayName("레이킹카 리뉴얼 버전")
    void test_레이싱카(){
        String[] names = {"a", "b", "c"};
        int count = 5;
        Racing racing = new Racing(names,count);
        racing.start();
    }

    @Test
    @DisplayName("들어온 이름의 길이가 5를 넘어간다면?")
    void test_이름길이가_5글자를_넘는경우(){
        String[] names = {"aaaaaa", "b","c"};
        int count = 5;
        assertThrows(RuntimeException.class, ()->new Racing(names, count));
    }
}
