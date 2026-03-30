package racingcar.domain;


/**
 * 움직일 수 있는 사물을 둘러싼 환경에 대해 설명합니다.
 *
 * <ul>
 *     <li>대상은 움직이면서 온갖 장애물을 만납니다. 이러한 장애물을 만날 경우 앞으로 나아갈 수 없습니다.</li>
 * </ul>
 */
public record Environment(ObstaclesAhead obstacles) {

    public enum MoveResult {MOVE, STOP}


    public MoveResult tryAdvance() {
        if (obstacles.tryAvoid() == ObstaclesAhead.Result.BLOCKED) {
            return MoveResult.STOP;
        }

        return MoveResult.MOVE;
    }


    public static final Environment PASS = new Environment(new ObstaclesAhead.NoObstacles());
    public static final Environment STOP = new Environment(new ObstaclesAhead.Blocked());

}
