package view;

import java.util.Scanner;

public class Input {


    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String str;
        String[] names;

        while(true) {

            str = scanner.nextLine();

            names = str.split(",");

            if(nameIsGood(names))break;
            System.out.println("이름은 5글자 이내로 다시 작성해주세요");

        }

        return names;
    }

    public static int getCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    public static boolean nameIsGood(String [] names){
        for(var name: names){
            if(name.length()>=5)return false;
        }
        return true;
    }

}
