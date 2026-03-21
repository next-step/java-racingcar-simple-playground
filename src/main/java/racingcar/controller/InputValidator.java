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
        validateNumber(inputTryCount);
        validateCountRange(inputTryCount);
        return Integer.parseInt(inputTryCount);
    }

    private void validateNumber(String inputTryCount) {
        try {
            Integer.parseInt(inputTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }
    }

    private void validateCountRange(String inputTryCount) {
        if (Integer.parseInt(inputTryCount) <= 0) {
            throw new IllegalArgumentException("1번 이상의 시도를 해야 합니다.");
        }
    }
}
