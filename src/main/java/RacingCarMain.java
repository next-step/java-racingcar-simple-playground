import java.util.Random;
import java.util.Scanner;

public class RacingCarMain {

    public static void main(String[] args){

        RacingCar game=new RacingCar();

        Scanner scanner=new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분):");
        String input= scanner.nextLine();
        String[] carNames=input.split(","); //, 단위로 끊어서 이름 배열 만들기

        CarList carList=new CarList(carNames);  //자동차 리스트 생성

        System.out.println("시도할 횟수는 몇 회인가요?");
        int r= scanner.nextInt();   //시도 횟수 입력 받기

        System.out.println();
        System.out.println("실행 결과");

        for(int i=0;i<r;i++){   //실행 결과 화면에 출력
            game.printCarNameOutput(carList);
            System.out.println();
        }

        game.printWinners(carList); //최종 우승자를 찾기 위해 메소드 호출
    }
}
