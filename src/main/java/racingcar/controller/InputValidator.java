package racingcar.controller;

import racingcar.model.Car;

import java.util.List;

public class InputValidator {
    public List<Car> validateCarName(List<String> nameList) {
        validateNameCount(nameList);
        return nameList.stream()
                .map(Car::new)
                .toList();
    }

    private void validateNameCount(List<String> carNameList) {
        if (carNameList.size() <= 1) {
            throw new IllegalArgumentException("게임 플레이에는 2명 이상이 필요합니다.");
        }
    }

    public int validatePlayCount(String inputTryCount) {
        int parsedCount = validateNumber(inputTryCount);
        validateCountRange(parsedCount);
        return parsedCount;
    }

    private int validateNumber(String inputTryCount) {
        try {
            return Integer.parseInt(inputTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }
    }

    private void validateCountRange(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("1번 이상의 시도를 해야 합니다.");
        }
    }
}
