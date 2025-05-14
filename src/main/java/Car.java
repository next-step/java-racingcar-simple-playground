public class Car {
    private int position = 0;
    private final String name;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다.");
        }
    }

    public void move(int randomNumber) {
        if(canMove(randomNumber)){
            position++;
        }
    }

    private boolean canMove(int randomNumber) {
        return randomNumber >= 4;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
