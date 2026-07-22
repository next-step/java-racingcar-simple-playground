package mission2;

import mission4.RandomNum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarTest2 {
    @Test
    @DisplayName("레이싱 게임 시작")
    void test_레이싱카(){
        String[] names = {"a", "b", "c"};
        int count = 5;
        Racing racing = new Racing(names,count,new RandomNum(10));
        racing.start();
    }

    @Test
    @DisplayName("들어온 이름의 길이가 5를 넘어간다면 예외처리")
    void test_이름길이가_5글자를_넘는경우_예외처리(){
        String[] names = {"aaaaaa", "b","c"};
        int count = 5;
        assertThrows(IllegalArgumentException.class, ()->new Racing(names, count, new RandomNum(10)));
    }

    @Test
    @DisplayName("객체를 생성하기 이전에 동일한 플레이어 이름이 존재하는 경우 예외처리")
    void test_동일한_이름이_존재한다면_예외처리(){
        String[] names = {"a", "a", "c"};
        int count = 5;
        assertThrows(IllegalArgumentException.class, ()->new Racing(names, count, new RandomNum(10)));
    }
}
