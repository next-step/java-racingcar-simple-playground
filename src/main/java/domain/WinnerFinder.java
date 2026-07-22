package domain;

import java.util.ArrayList; // 우승자 여러 명 저장 가능
import  java.util.List;

public class WinnerFinder {
    public  List<String> findWinners(List<Car> cars) { // 자동치 목록 전달 받아 우승자 이름 목록 반환
        int maxPosition = findMaxPosition(cars); // 모든 자동차 중 가장 큰 위치 구함
        List<String> winners = new ArrayList<>(); // 우승 자동차 이름 저장할 빈 목록 만듬

        for (Car car : cars) { // 자동차 목록에 들어 있는 자동차 한 대씩 꺼냄
            addWinner(car, maxPosition, winners); // 현재 자동차가 우승자인지 검사
        }
        return winners; // 모든 자동차 확인 끝나면 우승자 이름 목록 반환
    }
    private  int findMaxPosition(List<Car> cars) { // 자동차 중 가장 큰 위치 구하는 메서드(private이므로 클래스 내부에서만 사용)
        int maxPosition = 0; // 가장 큰 위치 저장하는 변수

        for (Car car:cars) { // 자동차 한 대씩 확인
            maxPosition = Math.max(maxPosition, car.getPosition()); // 최대 위치와 현재 자동차의 위치 중 더 큰 값 선택
        }
        return maxPosition; // 최종적으로 찾은 가장 큰 위치 반환
    }
    private void addWinner(Car car, int maxPosition, List<String> winners) { // 우승자 목록에 추가하는 메서드
        if (car.getPosition() == maxPosition) { // 현재 자동차의 위치가 가장 큰 위치일 시
            winners.add(car.getName()); // 현재 자동차의 이름을 우승자 목록에 추가
        }
    }
}