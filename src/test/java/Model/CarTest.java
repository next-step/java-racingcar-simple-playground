package Model;

import Model.Car;
import Model.CarName;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("4~9의 값이면 움직인다.")
    @Test
    void right_move(){
        int number = 4;
        Car car = new Car(new CarName("abc"));
        car.move(number);
        Assertions.assertThat(car.position).isEqualTo(1);
    }

    @DisplayName("승리자가 맞으면 트루를 출력한다.")
    @Test
    void right_winner(){
        int winnerPoint = 4;
        Car car = new Car(new CarName("abc"));
        car.position = 4;
        Assertions.assertThat(car.isWinner(winnerPoint)).isEqualTo(true);
    }
}
