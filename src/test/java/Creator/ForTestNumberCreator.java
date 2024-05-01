package Creator;
import java.util.List;

public class ForTestNumberCreator implements NumberCreator{
    private List<Integer> numbers;
    private int index;

    public ForTestNumberCreator(List<Integer> numbers) {
        this.numbers = numbers;
        this.index = 0;
    }

    @Override
    public int returnNumber() {
        int number = numbers.get(index);
        index++;
        return number;
    }
}
