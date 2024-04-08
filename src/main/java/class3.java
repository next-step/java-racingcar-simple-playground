import java.util.Scanner;
import java.util.Arrays;
import java.util.OptionalInt;


public class class3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요");
        String input = scanner.nextLine();
        String[] carNames = input.split(",");
        int carNum = carNames.length;
        int[] carRes = new int[carNum];
        Arrays.fill(carRes,1);

        System.out.println("시도할 회수는 몇회인가요?");
        int n = scanner.nextInt();


        for(int i=0; i < n + 1; i++){
            if (i == 0) {
                System.out.println("실행 결과");
            }
            for(int j=0; j<carNum; j++){
                if (i == 0){
                    System.out.println(carNames[j] + ":" + "-");
                }
                if (i != 0) {
                    carRes[j] = class1.position(carRes[j]);
                    System.out.println(carNames[j] + ":" + "-".repeat(carRes[j]));
                }
            }
            System.out.println();
            if (i == n) {
            }
        }

        int maxDistance = Arrays.stream(carRes).max().getAsInt();

        // 최대 이동 거리를 가진 자동차들을 찾아서 배열에 넣습니다.
        String[] winners = new String[carNum];
        int winnerCount = 0;
        for (int i = 0; i < carNum; i++) {
            if (carRes[i] == maxDistance) {
                winners[winnerCount] = carNames[i];
                winnerCount++;
            }
        }

        // 최종 우승자를 출력합니다.
        System.out.print("최종 우승자: ");
        for (int i = 0; i < winnerCount; i++) {
            System.out.print(winners[i]);
            if (i != winnerCount - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

}
