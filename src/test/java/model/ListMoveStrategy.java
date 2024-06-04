package model;

import java.util.List;

public class ListMoveStrategy implements MoveStrategy {

    private final List<Integer> numbers;


    public ListMoveStrategy(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int getNumber() {
        return numbers.remove(0);
    }
}
