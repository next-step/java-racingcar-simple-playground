package view;

import domain.Car;
import domain.Cars;
import java.util.ArrayList;
import java.util.List;

public class ResultView {

    //라운드간 우승자 출력하기
    public static void printRound(Cars carsList) {
        for (Car car : carsList.getCars()) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getCarPosition()));
        }
        System.out.println();
    }
    //repeat()는 문자열 반복 메서드임. car.getCarPosition()만큼 "-"를 반복해서 출력하는거.

    //최종 우승자 출력하기
    public static void printFinalWinners(List<Car> winners) {
        List<String> names = new ArrayList<>();
        for (Car car : winners) {
            names.add(car.getCarName()); // Car에서 이름만 뽑아서 새 리스트에 담음
        }
        System.out.println(String.join(", ", names) + "가 최종 우승했습니다.");
    }
    //String.join(", ", ["neo", "brown"]) → "neo, brown" 이렇게 합쳐주는거임.

}
