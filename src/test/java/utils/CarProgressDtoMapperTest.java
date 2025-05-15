package utils;

import domain.Car;
import domain.MoveCondition;
import domain.Name;
import dto.CarProgressDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarProgressDtoMapperTest {

    @Test
    @DisplayName("Car 리스트를 CarProgressDto 리스트로 변환한다")
    void mapCarsToDtos() {
        Car car1 = new Car(new Name("neo"));
        Car car2 = new Car(new Name("brie"));

        MoveCondition alwaysMove = new MoveCondition(() -> 9);

        car1.move(alwaysMove);
        car2.move(alwaysMove);
        car2.move(alwaysMove);

        List<Car> cars = List.of(car1, car2);

        List<CarProgressDto> dtos = CarProgressDtoMapper.from(cars);

        assertThat(dtos).hasSize(2);
        assertThat(dtos.get(0)).isEqualTo(new CarProgressDto("neo", 1));
        assertThat(dtos.get(1)).isEqualTo(new CarProgressDto("brie", 2));
    }
}
