package NumberGenerator;

public class FixNumberGenerator implements NumberGenerator {
    private int[] number;
    private int index=0;

    public FixNumberGenerator(int[] number) {
        this.number = number;
    }

    @Override
    public int generate(){
        return number[index++];
    }
}
