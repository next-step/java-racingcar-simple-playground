import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, t; //자동차 개수랑 경기횟수

        ArrayList<String> names = saveNames(sc);

        n = names.size(); //자동차 개수
        System.out.println("시도할 회수는 몇회인가요?");
        t = sc.nextInt(); //경기 횟수

        Racing rc = new Racing();
        rc.racing(n, t, names);
        rc.winner();

        print(rc);
        
        sc.close();
    }

    static ArrayList<String> saveNames(Scanner sc) {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String name_tmp = sc.next();
        ArrayList<String> names = new ArrayList<>(); //자동차 이름 모아둘 곳
        String[] name = name_tmp.split(",");
        Collections.addAll(names, name); //names에 이름들 저장
        return names;
    }

    static void print(Racing rc) {
        for (int i = 0; i < rc.winCars.size(); i++) {
            if (i == rc.winCars.size() - 1) {
                System.out.println(rc.winCars.get(i).name + "가 최종 우승했습니다.");
            } else
                System.out.print(rc.winCars.get(i).name + ",");
        }
    }
}
