package car.model;

public class GameNumber {
    private  int gameNumber;

    public GameNumber(String num){
        validateType(num);
    }

    public int getGameNumber() {
        return gameNumber;
    }

    private void validateType(String num) {
        try {
            this.gameNumber = Integer.parseInt(num);
        }
        catch (Exception e){
            throw new IllegalArgumentException("숫자만 입력하세요.");
        }
    }
}
