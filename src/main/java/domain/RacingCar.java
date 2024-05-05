package domain;

public class RacingCar {
    private String name;
    private int position;

    public RacingCar(String name){
        this.name = name;
        this.position = 0;
    }

    public int move(){
        int random = generateRamdomNum();
        if(random >= 4){
            return ++position;
        }
        return position;
    }

    public int generateRamdomNum(){
        return (int) Math.random() * 10;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
