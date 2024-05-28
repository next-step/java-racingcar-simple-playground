package util;

public class CustomGenerator implements NumberGenerator {
    private final int input;

    public CustomGenerator(int input){
        this.input = input;
    }

    public int generateNum(){
        rangeCheck(input);
        return input;
    }
}
