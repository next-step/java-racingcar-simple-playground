import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;


class RacingCarTest {

    RacingCar racingCar = new RacingCar();

    @RepeatedTest(5)  // 테스트를 여러 번 반복할 수 있음
    @DisplayName("붕붕이 상태 확인하기")
    void racingCarStatus() {
        String name = racingCar.carName();
        int number = racingCar.randomNumber();
        boolean carStatus = number > RacingCar.fixNumber;

        System.out.println("자동차 이름: " + name);
        System.out.println("난수: " + number);
        if (carStatus) {
            System.out.println(name + "는 " + number + " 만큼" + " 전진했습니다");
        } else {
            System.out.println(name + "는 " + number + " 가 나와" + " 멈췄습니다");
        }

        System.out.println("----------");
    }

}
