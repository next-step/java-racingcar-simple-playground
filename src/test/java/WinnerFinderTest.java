import racinggame.model.car.Car;
import racinggame.model.car.policy.strategy.MoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.model.WinnerFinder;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class WinnerFinderTest {

    @Test
    @DisplayName("우승자 1명일 경우 car1")
    public void singleWinner(){
        // given
        List<Car> cars = createCarsForTest(new int[]{3,2,1},new String[]{"car1","car2","car3"});
        WinnerFinder winner=new WinnerFinder(cars,1);

        // when
        winner.play();

        // then
        List<String> winners = winner.getWinners();
        assertThat(winners).containsExactly("car1");
    }

    @Test
    @DisplayName("우승자 여러명일 경우 car1 car2")
    public void multipleWinners(){
        // given
        List<Car> cars = createCarsForTest(new int[]{3,3,1},new String[]{"car1","car2","car3"});
        WinnerFinder winner=new WinnerFinder(cars,1);

        // when
        winner.play();

        // then
        List<String> winners = winner.getWinners();
        assertThat(winners).containsExactly("car1", "car2");
    }


    private List<Car> createCarsForTest(int[] distances,String[] names){
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i],fixedStrategy(distances[i])));
        }
        return cars;
    }

    // 테스트 코드에만 존재하면 되므로 배포되지 않는 test 패키지안에 구현
    // MoveStrategy 은 addStepSize( ) 하나의 메소드만 있다.
    // 함수형 인터페이스를 사용한다.
    private MoveStrategy fixedStrategy(int distance){
        return ()->distance;
    }

}