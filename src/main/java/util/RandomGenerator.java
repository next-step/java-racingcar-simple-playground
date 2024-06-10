package util;

public class RandomGenerator implements NumberGenerator{
    public int generateNum(){
        int random = (int) (Math.random() * 10);
        rangeCheck(random);
        return random;
    }
}
