package validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static model.Car.MAX_CAR_NAME_LENGTH;

public class CarNamesStringValidator {
    public static void validate(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름을 하나 이상 입력해 주세요.");
        }

        for (String carName : carNames) {
            if (carName.isBlank()) {
                throw new IllegalArgumentException("자동차의 이름은 비어 있어서는 안 됩니다.");
            }

            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차의 이름의 길이는 " + MAX_CAR_NAME_LENGTH + "자를 넘어서는 안 됩니다.");
            }
        }

        Set<String> carNamesInSet = new HashSet<>(carNames);

        if (carNames.size() > carNamesInSet.size()) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
        }
    }
}
