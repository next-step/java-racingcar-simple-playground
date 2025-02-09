package model.dto;

import model.Car;

import java.util.List;
import java.util.Map;

public record RacingPlayResponse(
        List<Map<String, Integer>> moveData,
        List<Car> winners
) {
}
