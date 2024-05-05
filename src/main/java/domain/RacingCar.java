package domain;

public class RacingCar {
    private String name;
    private int position;

    RacingCar(String name){
        this.name = name;
        this.position = 0;
    }

    public int move(int random){
        if(random >= 4){
            return ++this.position;
        }
        return this.position;
    }
}
