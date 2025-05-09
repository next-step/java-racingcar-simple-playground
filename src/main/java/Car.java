public class Car {
    private int position;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    // 테스트를 위해 추가함
    public Car(String name, int position){
        this.name = name;
        this.position = position;
    }

    public void move(RandomNumberProvider provider, Mover mover) {
        int randomNumber = provider.getRandomNumber();
        position += mover.move(randomNumber);
    }

    // private으로 작성했기 때문에 get 사용
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionDisplay() {
        return name + " : " + "-".repeat(position);
    }
}
