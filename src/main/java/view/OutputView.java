package view;

import domain.Car;

import dto.CarDto;

import java.util.List;

public class OutputView {
    public void printCars(List<CarDto> carDtos) {
        for (CarDto carDto : carDtos) {
            printCar(carDto);
        }
        System.out.println();
    }

    private void printCar(CarDto carDto) {
        System.out.print(carDto.name() + " : ");

        for (int i = 0; i < carDto.position(); i++) {
            System.out.print("-");
        }

        System.out.println();
    }

    public void printWinners(List<String> winnerNames) {
        String joinedNames = String.join(", ",  winnerNames);

        System.out.println(joinedNames + "가 최종 우승했습니다.");
    }

    public void printResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }
}
