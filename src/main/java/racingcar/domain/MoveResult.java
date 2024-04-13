package racingcar.domain;

public record MoveResult(String carName, int currentPosition) {

    public static MoveResult from(final Car car) {
        return new MoveResult(car.getName(), car.getPosition());
    }
}
