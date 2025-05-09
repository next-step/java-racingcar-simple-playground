public class Car {
    private int position;
    private final String name;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name){
        if(name.length()>5){
            throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다.");
        }
    }

    public void move(RandomNumberProvider provider, Mover mover) {
        int randomNumber = provider.getRandomNumber();
        position += mover.move(randomNumber);
    }

    public void move(int number) {
        if (number >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
