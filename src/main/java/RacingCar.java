public class RacingCar {
    /**
     * 자동차는 이름을 가지고 있다.
     * 자동차는 움직일 수 있다.
     * 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
     */
    // 자바 네이밍 규칙에 따라 상수는 대문자로 작성
    public static final int FIX_NUMBER = 3; // 기준값 선언
    private final String carName;
    private final RandomNumber randomNumber;

    public RacingCar(String carName, RandomNumber randomNumber) {
        this.carName = carName;
        this.randomNumber = randomNumber;
    }

    public String getCarName() {
        return this.carName;
    }

    public boolean racingCarStatus() {
        int num = randomNumber.instanceNumber();
        if (num > FIX_NUMBER) {
            return true;
        }
        return false;
        // early return 을 사용하여 가독성을 높임
        // 요구사항에 있는 else 를 사용하지 않고 넘어감
    }
}
