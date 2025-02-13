public class Car {
    int position = 0;
    public int carNumber;
    public String carName;

    public Car() {
        this.position = 0;
    }

    public Car(int carNumber, String carName) {
        this.carNumber = carNumber;
        this.carName = carName;
    }

    public int getRandom() {
        double randomValue = Math.random();
        return (int) (randomValue * 9);
    }

    public boolean getStatus() {
        int randomValue = getRandom();
        boolean result = true;

        if (randomValue <= 3) {
            result = false;
        }

        return result;
    }

    public void tryMove() {
        if(getStatus()) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }


    public String getCarName() {
        return carName;
    }

}
