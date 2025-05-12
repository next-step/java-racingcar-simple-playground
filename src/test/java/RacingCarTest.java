import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    //항상 이동을 하게끔 하는 고정 랜덤
    static class FixedRandom extends Random {
        private int fixedRandom;
        public FixedRandom(int fixedRandom){
            this.fixedRandom = fixedRandom;
        }

        @Override
        public int nextInt(int a){
            return fixedRandom;
        }
    }

    @Test
    @DisplayName("다같이 1등일 때")
    void AllWinnerTest() {
        String[] names = {"1등","2등","3등"};
        Random fixedRandom = new FixedRandom(5); // 5로 고정해서 모두 다 움직이게끔
        RacingCar game = new RacingCar(names,fixedRandom);

        game.playRound(4);

        assertThat(game.getWinner()).hasSize(3);
    }

    @Test
    @DisplayName("1명만 우승일 때")
    void WinnerOnlyOne(){
        String[] names = {"1등","2등",};
        //1등 -> 5 이동성공, 2등 -> 3 이동 실패
        RacingCar game = new RacingCar(names,new Random(){
            private int cnt = 0;
            @Override
            public int nextInt(int bound) {
                int result = 3;
                if (cnt % 2 == 0) {
                    result = 5;
                }

                cnt++;
                return result;
            }
        });

        game.playRound(4);

        assertThat(game.getWinner().get(0).name).isEqualTo("1등");
    }
}
