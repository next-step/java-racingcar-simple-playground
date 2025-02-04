import java.util.*;

public class Game {
    private List<RacingCar> racingCars = new ArrayList<>();

    static Scanner in = new Scanner(System.in);

    public static String inputCarName(){
        return in.nextLine();
    }

    public static int inputRunCount(){
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



    public int randomPick(){
        return new Random().nextInt();
    }

    public void gameStatePrint(){

    }

    public void firstGameStart(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void gameResultPrint(){
        System.out.println("실행 결과");
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
