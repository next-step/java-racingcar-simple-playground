package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Racing
{
    private final int tryCount;
    private final List<Car> cars = new ArrayList<>();

    // 생성자 함수
    public Racing(String tempCarNames, int count)
    {
        for (String name: checkCarCount(splitCarName(tempCarNames)))
            addCar(name);

        tryCount = checkTryCount(count);
    }

    // 자동차의 이름을 ","로 분리 및 에러 체크
    private String[] splitCarName(String carName)
    {
        return checkFiltering(carName.split(","));
    }

    // 이름이 5글자 이하의 차만 필터링
    private String[] checkFiltering(String[] tempCarName)
    {
        return Arrays.stream(tempCarName)
                .filter(name -> name.length() <= 5)
                .toArray(String[]::new);
    }

    // 에러 처리 : car 개수 체크
    private String[] checkCarCount(String[] carName)
    {
        if (carName.length == 0)
            throw new IllegalArgumentException("경주를 진행할 차가 없습니다.");

        return carName;
    }

    // 에러 처리 : tryCount 체크
    private int checkTryCount(int tryCount)
    {
        if (tryCount <= 0)
            throw new IllegalArgumentException("자연수를 입력해 주세요.");

        return tryCount;
    }

    // Car 객체 생성
    private void addCar(String curCarName)
    {
        Car curCar = new Car(curCarName);
        cars.add(curCar);
    }

    // 모든 자동차에 대해 경주 진행
    public void startRace(int raceCount)
    {
        for (int i=0; i<raceCount; i++)
            cars.forEach(Car::moveCar);
    }

    // 가장 멀리 간 자동차의 위치 탐색
    private int findMaxPos()
    {
        return cars.stream()
                .mapToInt(Car::getCarPos)
                .max()
                .orElseThrow();
    }

    // 우승자 탐색
    public List<String> getWinners()
    {
        return cars.stream()
                .filter(car -> car.getCarPos() == findMaxPos())
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    // 경주 진행
    public void race()
    {
        startRace(tryCount);
    }
}
