import domain.Car;
import domain.RacingGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGameTest {

    List<Car> cars = new ArrayList<>(Arrays.asList(new Car("CarA",1),
            new Car("CarB",4),new Car("CarC",2)));

    RacingGame racingGame=racingGame = new RacingGame(cars,5);;

    @Test
    public void playOneRoundRaceTest(){

        List<Integer> randomNumbers = List.of(5,3,9);

        RacingGameTestable racingGameTestable = new RacingGameTestable(cars,1,randomNumbers);

        racingGameTestable.playOneRoundRace();

        Assertions.assertEquals(2,cars.get(0).getPosition());
        Assertions.assertEquals(4,cars.get(1).getPosition());
        Assertions.assertEquals(3,cars.get(2).getPosition());

    }


    @Test
    public void getMaxPositionTest(){
        int maxPosition = racingGame.getMaxPosition();

        Assertions.assertEquals(4,maxPosition);
    }


    @Test
    public void getWinnersTest(){
        String winners = racingGame.getWinners();

        Assertions.assertEquals("CarB",winners);
    }

    @Test
    public void getDuplicatedWinnersTest(){
        List<Car> cars2 = new ArrayList<>(Arrays.asList(new Car("CarA",1),
                new Car("CarB",4), new Car("CarC",2),new Car("CarD",4)));

        RacingGame racingGame2=racingGame = new RacingGame(cars2,5);;

        String winners = racingGame2.getWinners();

        Assertions.assertEquals("CarB,CarD",winners);
    }


    public class RacingGameTestable extends RacingGame {
        private final List<Integer> randomNumbers;
        private int index = 0;

        public RacingGameTestable(List<Car> cars, int raceCnt, List<Integer> randomNumbers) {
            super(cars, raceCnt);
            this.randomNumbers = randomNumbers;
        }

        public int createRandomNum() {
            return randomNumbers.get(index++);
        }

        public void playOneRoundRace(){
            int index = 0;

            for (Car car : cars) {
                if (randomNumbers.get(index++)>=4){
                    car.forward();
                }
            }
        }
    }

}
