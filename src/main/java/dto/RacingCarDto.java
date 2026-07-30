package dto;

import domain.RacingCar;

public class RacingCarDto {
    private final String name;
    private final int position;

    public RacingCarDto (RacingCar racingCar) {
        name = racingCar.getName();
        position = racingCar.getPosition();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
