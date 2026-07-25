package view;

public class InputHandler {
    View view = new View();
    private String[] carNames;
    private int number;

    public void inputHandling() {
        String[] carNames = view.intro();

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차이름은 5자를 넘길수 없습니다.");
            }
        }
        this.carNames = carNames;
        int number = view.inputNum();
        this.number = number;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getNumber() {
        return number;
    }
}
