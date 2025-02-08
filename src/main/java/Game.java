import java.util.*;

public class Game {

    private List<RacingCar> racingCars = new ArrayList<>();
    private int runCount = 0;
    static Scanner in = new Scanner(System.in);

    public static String inputCarName(){
        String carName = in.nextLine();
        if(carName == null || carName.isEmpty()) throw new RuntimeException("자동차 이름을 제대로 입력해주세요.");
        return carName;
    }

    private int inputRunCount(){
        int runCount;
        try{
            runCount = in.nextInt();
            runCountMinusCheck(runCount);
        }
        catch (NumberFormatException e) {
            throw new RuntimeException("정수만 가능합니다.");
        }
        return runCount;
    }

    private void runCountMinusCheck(int runCount){
        if(runCount <= 0) throw new RuntimeException("실행횟수가 0이하 입니다.");
    }

    private void setRunCount(){
        runCount = inputRunCount();
    }

    private String[] splitInput(String carNameInput){
        return carNameInput.split(",");
    }

    private Set<String> setCarName(String[] carNameInput){
        Set<String> carNames = new HashSet<>();
        for(var name : carNameInput) carNames.add(name.trim());
        if(carNames.isEmpty()) throw new RuntimeException("");
        return carNames;
    }

    private void setCar(String[] carNameInput){
        var carNames = setCarName(carNameInput);
        for(var name : carNames) racingCars.add(new RacingCar(name));
    }

    public int randomPick(){
        return new Random().nextInt(9);
    }

    private void gameRun(){
        for(var car : racingCars){
            carCanGo(randomPick(), car);
        }
    }

    private void carCanGo(int randomNumber, RacingCar car){
        if(randomNumber >= 4) car.move(randomNumber);
    }

    private void gameStatePrint(){
        gameRun();
        for(var car : racingCars) System.out.println(car.getCarName() + " : " + "-".repeat(car.getForwardCount()));
        System.out.println();
    }

    private int pickWinnerCalc(RacingCar car, List<String> winnerCar, int max){
        if(car.getForwardCount() > max){
            winnerCar.clear();
            winnerCar.add(car.getCarName());
            max = car.getForwardCount();
        }
        else if(car.getForwardCount() == max){
            winnerCar.add(car.getCarName());
        }
        return max;
    }

    private List<String> pickWinner(){
        List<String> winnerCars = new ArrayList<>();
        int max = 0;
        for(var car : racingCars){
            max = pickWinnerCalc(car, winnerCars, max);
        }
        return winnerCars;
    }

    private void printWinner(List<String> winnerCars){
        System.out.println("최종 우승자 : " + String.join(", ", winnerCars));
    }

    private void gameSetting(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        setCar(splitInput(inputCarName()));
        System.out.println("시도할 횟수는 몇회인가요?");
        setRunCount();
    }

    private void gameResultPrint(){
        System.out.println();
        System.out.println("실행 결과");
        for(int i = 0; i<runCount; ++i){
            gameStatePrint();
        }
        printWinner(pickWinner());
    }

    public static void runTest(){
        Game game = new Game();
        game.gameSetting();
        game.gameResultPrint();
    }

    public static void main(String[] args){
        runTest();
    }
}
