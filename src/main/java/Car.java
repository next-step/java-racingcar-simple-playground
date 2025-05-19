public class Car {

    private final String name;
    private int distance;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public Car(String name) {
        this.name = validateName(name);
        this.distance = 0;
    }

    private String validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("차량 이름은 5자 이하여야합니다.");
        }
        return name;
    }

    public void move(int number) {
        if (canMove(number)) {
            this.distance++;
            System.out.println("차량 \"" + this.name + "\"이 전진합니다. 거리: " + this.distance + "");
        }
    }

    private boolean canMove(int number) {
        return number >= 4;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
		return name;
    }
}
