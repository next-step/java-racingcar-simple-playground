import java.util.List;

public class FakeGenerator implements NumberGenerator {

    List<Integer> list;

    public FakeGenerator(List<Integer> list) {
        this.list = list;
    }

    @Override
    public int getRandomNumber() {
        return list.remove(0);
    }

}
