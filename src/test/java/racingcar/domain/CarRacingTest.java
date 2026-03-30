package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;


@SuppressWarnings("NonAsciiCharacters")
public class CarRacingTest {

    @Test
    void 시나리오_테스트() {
        List<String> carStringNames = List.of("a", "b", "c", "d", "e");
        List<Car.Name> carNames = carStringNames.stream()
                .map(Car.Name::new)
                .toList();

        int carCount = carNames.size();
        int gameCount = 8;

        CarRacing racing = new TestCarRacing(carNames, gameCount);

        assertThat(racing.cars).hasSize(carCount);
        assertThat(racing.gameCount).isEqualTo(gameCount);

        for (int i = 0; i < carCount; i++) {
            Car car = racing.cars.get(i);

            assertThat(car).isNotNull();
            assertThat(car.getPosition()).isEqualTo(0);
            assertThat(car.name).isEqualTo(carNames.get(i));
        }

        CarRacing.GameResult result = racing.playGame();

        assertThat(result.winners())
                .hasSizeGreaterThan(0)
                .allSatisfy(winner -> {
                    assertThat(winner.getPosition()).isGreaterThan(0);
                });

        assertThat(result.progressions())
                .hasSize(gameCount)
                .allSatisfy(progression -> {
                    var assertCars = assertThat(progression.cars());

                    assertCars.hasSize(carNames.size());

                    assertCars.map(CarRacing.CarProgression::getName)
                            .isEqualTo(carStringNames);

                    assertCars.allSatisfy(car -> {
                        assertThat(car.position()).isGreaterThanOrEqualTo(0);
                    });
                });

        assertThat(racing.cars).anySatisfy(car -> {
            assertThat(car.getPosition()).isGreaterThan(0);
        });
    }


    @Test
    void 최대_게임_횟수만큼_전진한다() {
        List<Car.Name> carNames = createNames("a", "b", "c");
        int gameCount = 10;

        CarRacing racing = new CarRacing(carNames, gameCount) {
            @Override
            protected Car createCar(Car.Name name) {
                return new Car(Environment.PASS, name);
            }
        };

        CarRacing.GameResult result = racing.playGame();
        assertThat(result.winners())
                .hasSize(racing.cars.size())
                .allSatisfy(winner -> {
                    assertThat(winner.getPosition()).isEqualTo(gameCount);
                });
    }

    @Test
    void 전진하지_않을_수도_있다() {
        List<Car.Name> carNames = createNames("a", "b", "c");
        int gameCount = 10;

        CarRacing racing = new CarRacing(carNames, gameCount) {
            @Override
            protected Car createCar(Car.Name name) {
                return new Car(Environment.STOP, name);
            }
        };

        CarRacing.GameResult result = racing.playGame();
        assertThat(result.winners())
                .hasSize(racing.cars.size())
                .allSatisfy(winner -> {
                    assertThat(winner.getPosition()).isEqualTo(0);
                });
    }


    private List<Car.Name> createNames(String... names) {
        return Stream.of(names)
                .map(Car.Name::new)
                .toList();
    }

}
