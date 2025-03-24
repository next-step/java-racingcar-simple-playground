package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static model.Cars.create;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CarsTest {

    List<String> carNames;

    @BeforeEach
    void setUp() {
        carNames = new ArrayList<>();
        carNames.add("BMW");
        carNames.add("Audi");
        carNames.add("Ford");
    }

    @Test
    void 자동차는_입력한_개수만큼_리스트에_추가된다() {
        Cars cars = create(carNames, new InplaceNumberGenerator());
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void 모든_자동차가_4보다_작은_랜덤값을_받으면_모든_자동차의_위치는_0이다() {
        Cars cars = create(carNames, new InplaceNumberGenerator());
        cars.moveAll();
        assertThat(cars.getCars().stream().allMatch(car -> car.hasSamePosition(0))).isTrue();
    }

    @Test
    void 모든_자동차가_4보다_큰_랜덤값을_받으면_모두_전진한다() {
        Cars cars = create(carNames, new MoveNumberGenerator());
        cars.moveAll();
        assertThat(cars.getCars().stream().allMatch(car -> car.hasSamePosition(1))).isTrue();
    }

    @Test
    void 매회_자동차가_전진하면_선두위치는_반복횟수와_같다() {
        int movingCount = 5;
        Cars cars = create(carNames, new MoveNumberGenerator());
        for (int i = 0; i < movingCount; i++) {
            cars.moveAll();
        }
        assertThat(cars.findLeadingPosition()).isEqualTo(movingCount);
    }

    @Test
    void 선두_자동차는_가장_멀리_이동한_자동차이다() {
        int movingCount = 5;
        Cars cars = create(carNames, new MoveNumberGenerator());
        for (int i = 0; i < movingCount; i++) {
            cars.moveAll();
        }
        Cars leadingCars = cars.getLeadingCars();
        assertThat(leadingCars.findLeadingPosition()).isEqualTo(cars.findLeadingPosition());
    }

    @Test
    void 선두가_두_명_이상_존재할_수_있다() {
        int movingCount = 5;
        Cars cars = create(carNames, new MoveNumberGenerator());
        for (int i = 0; i < movingCount; i++) {
            cars.moveAll();
        }
        Cars leadingCars = cars.getLeadingCars();
        assertThat(leadingCars.size()).isEqualTo(3);
    }

    @Test
    void getCars를_통해_얻은_객체를_변경하면_예외가_발생해야_한다() {
        Cars cars = create(carNames, new MoveNumberGenerator());
        List<Car> findCars = cars.getCars();

        assertThatThrownBy(() -> findCars.add(new Car("KIA")))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
