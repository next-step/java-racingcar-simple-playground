package utils;

import dto.CarProgressDto;

public class CarProgressFormatter {

    public static String format(CarProgressDto dto) {
        return dto.name() + " : " + "-".repeat(dto.position());
    }
}
