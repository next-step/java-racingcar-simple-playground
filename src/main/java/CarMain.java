
import java.util.Scanner;

public class CarMain {
  //  public int maxIndex(int[] arr,int max)

    public static void main(String[] args) {



        showFrowardCnt(cars,carNum);

        System.out.print("우승한 car : ");

        for(int i=0;i<carNum;i++)
        {
            forwardCnt[i] = cars[i].getSpeedCnt();
            maxCnt=Math.max(maxCnt,forwardCnt[i]);
        }

        for(int i=0;i<carNum;i++)
        {
            showFirstPrize(maxCnt, forwardCnt, i, cars);
        }

    }

    private static void showFirstPrize(int maxCnt, int[] forwardCnt, int i, Car[] cars) {
        if(maxCnt == forwardCnt[i])
        {
            System.out.print(cars[i].getName() + " " );
        }
    }


    private static void showFrowardCnt(Car[] cars,int carNum) {
        for(int i = 0; i< carNum; i++){
            System.out.println(cars[i].getName()+ "forwardCnt = " + cars[i].getSpeedCnt());
        }
    }

    private static void race(Car[] cars, int i, int raceNum) {
        cars[i] = new Car("F" + (i + 1));
        for(int j = 0; j< raceNum; j++)
        {
            cars[i].carMove();
        }
    }

}
