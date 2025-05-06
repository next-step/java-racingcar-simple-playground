package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CarRaceTest {
    @Mock
    NumberGenerator randomNumberGenerator;

    @Test
    @DisplayName("자동차 경주 우승자 테스트: 우승자 1명")
    void calculateWinner() {
        // Given
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        List<Car> cars = Arrays.asList(car1, car2);
        when(randomNumberGenerator.generate()).thenReturn(1,5,1,5,1,5);
        int playRounds = 3;
        CarRace carRace = new CarRace(cars,playRounds, randomNumberGenerator);

        // When
        carRace.start();

        // Then
        assertThat(carRace.getWinnerCarNames()).isEqualTo(Arrays.asList("b"));
    }

    @Test
    @DisplayName("자동차 경주 우승자 테스트: 우승자 여러명")
    void calculateWinners() {
        // Given
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        List<Car> cars = Arrays.asList(car1, car2);
        when(randomNumberGenerator.generate()).thenReturn(5,5,5,5,5,5);
        int playRounds = 3;
        CarRace carRace = new CarRace(cars,playRounds, randomNumberGenerator);

        // When
        carRace.start();

        // Then
        assertThat(carRace.getWinnerCarNames()).isEqualTo(Arrays.asList("a","b"));
    }
}
