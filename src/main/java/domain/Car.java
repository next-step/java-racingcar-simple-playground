package domain;

// 차량의 이름, 차량의 위치를 가져야 함.
public class Car {
    // 자동차의 이름(name)과 위치(position)를 나타내는 변수
    private final NumberGenerateStrategy strategy;
    private final CarName name;
    private int position;

    // 생성자(constructor)
    public Car(final NumberGenerateStrategy strategy, final String name) {
        this(strategy, name, 0);
    }

    public Car(final NumberGenerateStrategy strategy,
               final String name,
               final int position) {
        this.strategy = strategy;
        this.name = CarName.from(name);
        this.position = position;
    }

    public void move() {
        final int value = strategy.generate();
        if (value >= 4) {
            position++;
        }
    }

    public boolean isPositionSame(final int position) {
        return this.position == position;
    }

    public String getName() {
        return name.value();
    }

    public int getPosition() {
        return position;
    }


}

