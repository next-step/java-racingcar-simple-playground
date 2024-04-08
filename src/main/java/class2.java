import java.util.Scanner;
import java.util.Arrays;

public class class2 {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] car = new int[n];
        Arrays.fill(car,0);

        for(int i=0; i<3; i++){
            for(int j=0; j<n; j++){
                car[j] = class1.position(car[j]);
            }
        }

        for(int i=0; i<n; i++){
            System.out.println("car:" + i + "pos:" + car[i]);
        }
    }


}
