package domain;
import java.util.Arrays;
import java.util.List;

public class Car {
    public static void carRun (List<String> carNames, int n, int numberOfCars){
        //입력받은 자동차의 위치를 저장하는 배열
        int[] carRes = new int[numberOfCars];
        Arrays.fill(carRes, 1);


        for (int i = 0; i < n + 1; i++) {
            if (i == 0) {
                System.out.println("실행 결과");
            }
            for (int j = 0; j < numberOfCars; j++) {
                if (i == 0) {
                    System.out.println(carNames.get(j) + ":" + "-");
                    //get?
                }
                if (i != 0) {
                    carRes[j] = carPos.position(carRes[j]);
                    System.out.println(carNames.get(j) + ":" + "-".repeat(carRes[j]));
                }
            }

            System.out.println();
            if (i == n) {
                //?
            }
        }
    }
}
