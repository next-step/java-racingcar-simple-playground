package utils;

import dto.WinnersDto;

public class WinnersFormatter {

    public static String format(WinnersDto dto) {
        return String.join(", ", dto.names()) + "가 최종 우승했습니다.";
    }
}
