package racingcar.view;

public class ResultView {

    public static void printRaceResult(String[] carList, int[] raceResult){
        for ( int j = 0 ; j < carList.length ; j++ ){
            System.out.print(carList[j] + " : ");
            for ( int k = 0 ; k < raceResult[j] ; k++ ){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void printWinner(int max, String[] carList, int[] raceResult){
        int flag = 0;
        for ( int i = 0 ; i < carList.length ; i++ ){
            if ( raceResult[i] == max && flag == 0 ){
                System.out.print(carList[i]);
                flag = 1;
            }
            else if ( raceResult[i] == max && flag == 1 ){
                System.out.print(", " + carList[i]);
            }
        }
        System.out.print("가 최종 우승했습니다.");
    }


}
