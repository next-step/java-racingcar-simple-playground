import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CarSimulatorTest {

    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Nested
    class ConstructorTest {

        @Test
        void 자동차_시뮬레이터_생성_성공() {
            // Given
            List<String> carNames = Arrays.asList("자동차1", "자동차2", "자동차3");
            int numberOfRounds = 5;

            // When
            CarSimulator carSimulator = new CarSimulator(carNames, numberOfRounds);

            // Then
            assertThat(carSimulator).isNotNull();
        }

    }

    @Nested
    class SimulateTest {

        @Test
        void 시뮬레이션_실행_결과_출력_확인() {
            // Given
            List<String> carNames = Arrays.asList("자동차1", "자동차2");
            int numberOfRounds = 2;
            CarSimulator carSimulator = new CarSimulator(carNames, numberOfRounds);

            // When
            carSimulator.simulate();

            // Then
            String output = outputStream.toString();
            assertThat(output).contains("실행 결과");
            assertThat(output).contains("자동차1");
            assertThat(output).contains("자동차2");
        }

        @Test
        void 시뮬레이션_라운드_수만큼_실행() {
            // Given
            List<String> carNames = Arrays.asList("자동차1");
            int numberOfRounds = 3;
            CarSimulator carSimulator = new CarSimulator(carNames, numberOfRounds);

            // When
            carSimulator.simulate();

            // Then
            String output = outputStream.toString();
            String[] lines = output.split("\n");
            assertThat(lines.length).isGreaterThanOrEqualTo(7); //7줄 이상
        }
    }

    @Nested
    class GetWinnersTest {

        @Test
        void 우승자는_비어있지않음() {
            // Given
            List<String> carNames = Arrays.asList("우승자", "패배자");
            CarSimulator carSimulator = new CarSimulator(carNames, 0);

            // When
            String winners = carSimulator.getWinners();

            // Then
            assertThat(winners).isNotNull();
            assertThat(winners).isNotEmpty();
        }

    }

}
