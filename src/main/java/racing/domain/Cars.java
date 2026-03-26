package racing.domain;

import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
        validateDuplicate();
    }

    private void validateDuplicate() {
        long distinctCount = cars.stream()
                .map(Car::getName)
                .distinct()
                .count();
        if (distinctCount != cars.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 자동차 이름이 존재합니다.");
        }
    }

    // 불변성 보장: 외부에서 리스트를 수정하지 못하도록 읽기 전용 뷰 반환
    public List<Car> getCarList() {
        return Collections.unmodifiableList(cars);
    }
}
