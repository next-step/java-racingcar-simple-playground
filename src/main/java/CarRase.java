public class CarRase {

    public int getRandom() {
        double randomValue = Math.random();
        return (int) (randomValue * 9);
    }

    public boolean getStatus() {
        int randomValue = getRandom();
        boolean result = rsandomValue > 3;

        return result;
    }
}