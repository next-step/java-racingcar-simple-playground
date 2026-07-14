package mission2;

import org.junit.jupiter.api.Test;

import java.util.List;

public class RacingCarTest2 {
    @Test
    void test_레이싱카2(){
        Race race = new Race(5,3);
        String[] names = {"a", "b", "c"};
        List<String> list = race.getWinners(names);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i) + "가 우승했습니다.");
        }
    }
}
