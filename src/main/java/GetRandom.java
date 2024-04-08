import java.util.Random;

public class GetRandom {
    public static int getRandom(){     //0~9 사이의 숫자 리턴
        Random random=new Random();
        return random.nextInt(10);
    }
}
