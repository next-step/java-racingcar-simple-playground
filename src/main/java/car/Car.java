package car;

public class Car {
    private String name;
    private int position = 0;

    public void move(){
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int number = randomNumberGenerator.generate();
        if(number >=4){
            position ++;
        }
    }
}
