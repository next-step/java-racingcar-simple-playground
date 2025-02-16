import java.util.Scanner;

public class InputView {
    static Scanner in = new Scanner(System.in);

    public String inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carName = in.nextLine();
        if(carName == null || carName.isEmpty()) throw new RuntimeException("자동차 이름을 제대로 입력해주세요.");
        return carName;
    }

    public int inputRunCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
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
}
