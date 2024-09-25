package domain;

public class CarName {
    private String name;

    public CarName(String name){
        if (name.length()>5){
            throw new IllegalStateException("이름은 5자 이하입니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
