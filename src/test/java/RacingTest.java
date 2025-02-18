import domain.Car;
import domain.Racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.*;


public class RacingTest
{
    @Nested
    @DisplayName("Car 클래스 테스트")
    class TestCar
    {
        @Test
        @DisplayName("움직임 테스트")
        void movingTest()
        {
            int[] moveCount = new int[]{0, 0};
            for (int i=0; i<10000; i++)
            {
                String carName = String.format("car{%d}", i);
                Car car = new Car(carName);
                car.moveCar();
                if (car.getCarPos() == 1)
                    moveCount[1] += 1;
                else
                    moveCount[0] += 1;
            }
            System.out.print("0칸 이동 : " + moveCount[0] + ", 1칸 이동 : " + moveCount[1]);
        }

        @Test
        @DisplayName("이동 횟수 테스트")
        void moveCountTest()
        {
            assertThatThrownBy(() -> new Racing(new String[]{"a", "b", "c"}, -1)).hasMessage("자연수를 입력해 주세요.");
            assertThatThrownBy(() -> new Racing(new String[]{"a", "b", "c"}, 0)).hasMessage("자연수를 입력해 주세요.");
        }
    }

    @Nested
    class TestRace
    {
        @Test
        @DisplayName("차의 이름 테스트")
        void nameCheckTest()
        {
            assertThatThrownBy(() -> new Racing(new String[]{"abcdef"}, 1)).hasMessage("경주를 진행할 차가 없습니다.");
            assertThatThrownBy(() -> new Racing(new String[]{"adasds,asdasdas,sdwqwq"}, 1)).hasMessage("경주를 진행할 차가 없습니다.");
        }
    }
}
