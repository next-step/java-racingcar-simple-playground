package domain;

import objects.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CarTest {

    private Car mycar = new Car("aaa");

    @Test
    @DisplayName("moving 4이상일경우 한칸 앞으로 이동해야 한다.")
    void moving_4이상이면_position_한칸_증가한다() {

        mycar.move(4, 10);

        assertEquals(1, mycar.getPosition(), "[ERROR] 4이상일경우 position증가 안함");
    }

    @Test
    @DisplayName("moving 4보다 작으면 정지한다.")
    void moving_4보다_작으면_position_그대로다() {

        mycar.move(0, 4);

        assertEquals(0, mycar.getPosition(), "[ERROR] 4보다 작을경우 position 변동");
    }

    @Test
    @DisplayName("-----와 같은 이동거리를 표시하는 함수")
    void 자동차가_5번_앞으로_갔을때_getPositionToString_원하는_문자를_반환한다() {

        for (int i = 0; i < 5; i++) {
            mycar.move(5, 6);
        }

        String carPosition = mycar.getPositionToString();
        String expectedPosition = "-----";

        assertEquals(expectedPosition, carPosition, "[ERROR] getPostionToString 문제 발생");
    }

}
