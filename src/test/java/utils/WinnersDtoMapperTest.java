package utils;

import domain.Car;
import domain.Name;
import dto.WinnersDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersDtoMapperTest {

    @Test
    @DisplayName("Car 리스트를 WinnersDto로 변환한다")
    void mapCarsToWinnersDto() {
        Car car1 = new Car(new Name("neo"));
        Car car2 = new Car(new Name("brie"));

        List<Car> winners = List.of(car1, car2);

        WinnersDto dto = WinnersDtoMapper.from(winners);

        assertThat(dto.names()).containsExactly("neo", "brie");
    }
}
