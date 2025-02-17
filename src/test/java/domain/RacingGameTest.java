package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RacingGameTest {

    private RacingGame racingGame;
    private Random mockRandom;

    @BeforeEach
    void setUp() {
        mockRandom = mock(Random.class);
        racingGame = new RacingGame(new String[]{"haeun", "ram", "com"}, 1, mockRandom);
    }

    @Test
    void moveCars_랜덤값을_5로_고정하여_이동_테스트() {
        when(mockRandom.nextInt(10)).thenReturn(5);

        List<Car> cars = racingGame.getWinner();
        int beforePosition = cars.get(0).getPosition();

        cars.get(0).move(mockRandom.nextInt(10));
        assertEquals(beforePosition + 1, cars.get(0).getPosition());
    }

    @Test
    void get_winner_테스트() {

        Car car1 = new Car("haeun");
        Car car2 = new Car("ram");
        Car car3 = new Car("com");

        car1.move(3);
        car2.move(9);
        car2.move(5);
        car3.move(5);
        car3.move(9);

        RacingGame game = new RacingGame(List.of(car1, car2, car3), 1);
        List<Car> winners = game.getWinner();

        assertTrue(winners.contains(car2));
        assertTrue(winners.contains(car3));
    }
}
