package racingcar.controller;

import racingcar.model.Car;
import racingcar.constant.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public List<Car> validateCarName(List<String> nameList) {
        validateNameCount(nameList);
        validateDuplicateName(nameList);
        return nameList.stream()
                .map(Car::new)
                .toList();
    }

    private void validateNameCount(List<String> carNameList) {
        if (carNameList.size() <= 1) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_CAR_COUNT.getMessage());
        }
    }

    private void validateDuplicateName(List<String> carNameList) {
        Set<String> uniqueNameSet = new HashSet<>(carNameList);
        if (uniqueNameSet.size() != carNameList.size()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_DUPLICATE.getMessage());
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
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private void validateCountRange(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_TRY_COUNT.getMessage());
        }
    }
}
