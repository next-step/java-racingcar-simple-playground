public class Car {
    int position = 0;
    public int carNumber;

    public Car(int carNumber) {
        this.carNumber = carNumber;
    }

    // 0~9 랜덤값 구하기
    public int getRandom() {
        double randomValue = Math.random();
        return (int) (randomValue * 9);
    }

    // 3이하 정지, 4이상 전진
    public boolean canMoveForward() {
        int randomValue = getRandom();
        boolean result = true;

        if (randomValue <= 3) {
            result = false;
        }

        return result;
    }

    // 전진 시도
    public void tryMove() {
        if(canMoveForward()) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public int getCarNumber() {
        return carNumber;
    }

}
