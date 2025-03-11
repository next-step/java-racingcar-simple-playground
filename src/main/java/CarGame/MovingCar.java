package CarGame;

import java.util.Scanner;

class MovingCar {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        GameSet();
    }
    private static void GameSet(){

        String carName = getCarName();
        int targetDistance = getTargetDistance();
        Car car=new Car(carName);
        GameStart(car,targetDistance);
    }
    private static String getCarName() {
        System.out.print("자동차의 이름을 입력하세요: ");
        return scanner.nextLine();
    }
    private static int getTargetDistance() {

        System.out.print("목표 거리를 입력하세요: ");
        int target = Integer.parseInt(scanner.nextLine().trim());
        return target;

    }

    private static void GameStart(Car car,int targetDistance){
        while(car.getPosition()<targetDistance) {
            car.move();
        }
        System.out.println("목표 지점을 넘어갔으므로 게임을 종료합니다.");
    }

}

