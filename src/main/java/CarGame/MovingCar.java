package CarGame;

import java.util.Scanner;

class MovingCar {
    public static void main(String[] args) {
        GameSet();
    }
    private static void GameSet(){

        Scanner scanner=new Scanner(System.in);
        System.out.print("자동차의 이름을 입력하세요 :");
        String carName= scanner.nextLine();
        scanner.close();
        Car car=new Car(carName);
        GameStart(car);
    }
    private static void GameStart(Car car){
        int round=1;
        while(car.getPosition()<=30) {
            System.out.println(round+"라운드");
            car.move();
            round++;
        }
        System.out.println("게임을 종료합니다.");
    }

}

