import java.util.*;

public class Game {
    private List<RacingCar> racingCars = new ArrayList<>();
    private final int runCount = checkRunCountException();
    static Scanner in = new Scanner(System.in);

    public static String inputCarName(){
        String carName = in.nextLine();
        if(carName == null || carName.isEmpty()) throw new RuntimeException("자동차 이름을 제대로 입력해주세요.");
        return carName;
    }

    private static int checkRunCountException(){
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

    public static void runCountMinusCheck(int runCount){
        if(runCount <= 0) throw new RuntimeException("실행횟수가 0이하 입니다.");
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

    private void setCar(Set<String> carNames){
        for(var name : carNames) racingCars.add(new RacingCar(name));
    }

    public int randomPick(){
        int randomNumber;
        try{
            randomNumber = in.nextInt(9);
            randomNumberMinusCheck(randomNumber);
        }
        catch (NumberFormatException e) {
            throw new RuntimeException("정수만 가능합니다.");
        }
        return randomNumber;
    }

    public static void randomNumberMinusCheck(int randomNumber){
        if(randomNumber <= 0) throw new RuntimeException("실행횟수가 0이하 입니다.");
    }

    public void gameRun(){
        for(var car : racingCars){
            carCanGo(randomPick(), car);
        }
    }

    private static void carCanGo(int randomNumber, RacingCar car){
        if(randomNumber >= 4) car.increaseForwardCount(randomNumber);
    }

    public void firstGameStart(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void gameResultPrint(){
        System.out.println("실행 결과");

    }

    public void gameStatePrint(){

    }


    public static void runTest(){
        Game game = new Game();
        String name = inputCarName();
        System.out.println(new RacingCar(name).getCarName());
    }

    public static void main(String[] args){
        runTest();
    }
}
