package domain;

import util.NumberGenerator;

public class RacingCar {
    private String name;
    private int position;
    private NumberGenerator numberGenerator;

    public RacingCar(String name, NumberGenerator numberGenerator){
        this.name = name;
        this.position = 0;
        this.numberGenerator = numberGenerator;
    }

    public int move(){
        int random = numberGenerator.generateNum();
        if(random >= 4){
            position++;
        }
        return position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}