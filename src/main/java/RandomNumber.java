import java.util.Random;

public class RandomNumber {

    /**
     * 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
     */
    // 1. 정적(RandomNumber.numberStatus()) 호출용
    private static final Random random = new Random();
    private final Random instanceRandom;

    public static int numberStatus() {
        return random.nextInt(9) + 1;
        // 해당 난수를 RacingCar 클래스로 넘겨줌
    }

    public RandomNumber() {
        this.instanceRandom = new Random();
    }

    public RandomNumber(int seed) {
        this.instanceRandom = new Random(seed);
        // 시드를 고정하여 난수를 테스트 할 때 어떤 값이 나오는 지 확인이 가능함
    }

    public int instanceNumber() {
        return instanceRandom.nextInt(9) + 1;
    }

    // 0.0에서 10.0까지의 실수를 출력하는 Math.random 함수 사용
    // 정수형으로 형변환을 시켜 0부터 10까지 출력하지만 요구사항에서는 0~9사이의 값을 출력하는 걸 원해
    // 약간의 어지러움이 생김;;
    // int num = (int) (Math.random() * 9) + 1
    // 검색해보니 0이상 9미만(0.0~9.0)의 실수를 생성하고
    // 정수로 변환하기 때문에 결과적으로 1~9사이의 값이 출력됨
}
