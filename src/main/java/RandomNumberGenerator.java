import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private Random random = new Random();

    //랜덤값구하기
    @Override
    public int generate(){
        return random.nextInt(10);
    }
}
