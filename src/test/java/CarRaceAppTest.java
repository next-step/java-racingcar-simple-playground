import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import domain.Car;
import domain.CarNameParser;
import domain.CarRace;
import domain.NumberGenerator;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import view.OutputView;

public class CarRaceAppTest {
    @Mock
    NumberGenerator randomNumberGenerator;

    @Test
    @DisplayName("자동차 경주 애플리케이션 출력 테스트")
    void carRaceTest() {
        // Given
        MockitoAnnotations.openMocks(this);
        int gameRounds = 3;
        String carNamesInput = "a,b";
        CarNameParser carNameParser = new CarNameParser();
        List<Car> cars = carNameParser.parse(carNamesInput).stream().map(Car::new).toList();
        when(randomNumberGenerator.generate()).thenReturn(1, 5, 1, 5, 1, 5);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        OutputView outputView = new OutputView();
        CarRace carRace = new CarRace(cars, gameRounds, randomNumberGenerator);

        // When
        carRace.start();
        outputView.printGameResult(carRace.getGameRoundsOutput());
        outputView.printWinnerCarNames(carRace.getWinnerCarNames());

        // Then
        String output = outContent.toString();
        String[] lines = output.split("\\R");
        assertThat(lines).containsExactly(
                "",
                "실행결과",
                "a : ",
                "b : -",
                "",
                "a : ",
                "b : --",
                "",
                "a : ",
                "b : ---",
                "",
                "b가 최종 우승했습니다."
        );

        System.setOut(System.out);
    }
}
