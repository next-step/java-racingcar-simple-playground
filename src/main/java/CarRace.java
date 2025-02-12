public class CarRace {

    public int getRandom() {
        double randomValue = Math.random();
        return (int) (randomValue * 9);
    }

    public boolean getStatus() {
        int randomValue = getRandom();
        boolean result = randomValue > 3;

        return result;
    }
}
