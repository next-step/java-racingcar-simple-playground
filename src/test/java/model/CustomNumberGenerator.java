package model;

public class CustomNumberGenerator implements NumberGenerator {
    private final int[] values;
    private int index = 0;

    public CustomNumberGenerator(int... values) {
        this.values = values;
    }

    @Override
    public int generate() {
        return values[index++]; // 들어온 숫자들을 순서대로 하나씩 뱉어냄
    }
}
