public class RacingCar {
    /**
     * 자동차는 이름을 가지고 있다.
     * 자동차는 움직일 수 있다.
     * 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
     */
    public static final int fixNumber = 3; // 기준값 선언

    public String carName() {
        String carName = "붕붕이";
        return carName;
    }
    // 테스트 코드에서 차 이름을 가져오기 위해 메서드 생성



    public int randomNumber() {

        int num = (int) (Math.random() * 9) + 1;
        return num;
    }
    // 0.0에서 10.0까지의 실수를 출력하는 Math.random 함수 사용
    // 정수형으로 형변환을 시켜 0부터 10까지 출력하지만 요구사항에서는 0~9사이의 값을 출력하는 걸 원해
    // 약간의 어지러움이 생김;;
    // int num = (int) (Math.random() * 9) + 1
    // 검색해보니 0이상 9미만(0.0~9.0)의 실수를 생성하고
    // 정수로 변환하기 때문에 결과적으로 1~9사이의 값이 출력됨

    public boolean racingCarStatus() {

        int num2 = randomNumber();
        boolean result = num2 > fixNumber;

        return result;
    }
}
