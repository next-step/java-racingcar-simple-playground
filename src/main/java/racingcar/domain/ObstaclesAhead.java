package racingcar.domain;

import java.util.Random;


/**
 * 움직일 수 있는 사물이 마주치는 장애물을 나타냅니다. 이러한 장애물을 만날 경우 앞으로 나아갈 수 없습니다.
 *
 * @see Environment
 */
public interface ObstaclesAhead {

    enum Result {AVOIDED, BLOCKED}


    Result tryAvoid();


    class ByRandom implements ObstaclesAhead {
        private final Random random;

        public ByRandom() {
            random = new Random();
        }

        public ByRandom(long seed) {
            random = new Random(seed);
        }


        @Override
        public Result tryAvoid() {
            int probability = random.nextInt(10);
            if (probability >= 4) {
                return Result.AVOIDED;
            }
            return Result.BLOCKED;
        }
    }


    class Blocked implements ObstaclesAhead {
        @Override
        public Result tryAvoid() {
            return Result.BLOCKED;
        }
    }

    class NoObstacles implements ObstaclesAhead {
        @Override
        public Result tryAvoid() {
            return Result.AVOIDED;
        }
    }

}
