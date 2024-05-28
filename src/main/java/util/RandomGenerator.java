package util;

public class RandomGenerator implements NumberGenerator{
    public int generateNum(){
        return (int) (Math.random() * 10);
    }
}
