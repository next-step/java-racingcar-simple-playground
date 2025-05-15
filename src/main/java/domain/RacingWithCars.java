package domain;

import data.CarSnapShot;
import data.RoundResult;
import utils.NumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingWithCars {
    private final List<Car> participatingCars;
    private final int times;
    private final NumberGenerator numberGenerator;

    public RacingWithCars(String[] carNames, int times, NumberGenerator numberGenerator) {
        validateTimesIsAtLeastOne(times);
        this.participatingCars = Arrays.stream(carNames)
                .map(carName -> new Car(new CarName(carName)))
                .collect(Collectors.toList());
        this.times = times;
        this.numberGenerator = numberGenerator;
    }

    private void validateTimesIsAtLeastOne(int times) {
        if (times < 1) {
            throw new InvalidTimesException("게임 진행 횟수는 1 이상을 입력해주세요.");
        }
    }

    public RoundResult raceOneRound() {
        participatingCars
                .forEach(car -> car.move(numberGenerator));
        return getRoundResult();
    }

    public List<CarSnapShot> getWinner() {
        int maxDistance = participatingCars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new RuntimeException("참여중인 자동차가 없습니다."));

        return participatingCars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(car -> new CarSnapShot(car.getName(), car.getDistance()))
                .collect(Collectors.toList());
    }

    private RoundResult getRoundResult() {
        List<CarSnapShot> roundResult = participatingCars.stream()
                .map(car -> new CarSnapShot(car.getName(), car.getDistance()))
                .collect(Collectors.toList());
        return new RoundResult(roundResult);
    }

    public List<Car> getParticipatingCars() {
        return participatingCars;
    }

    public int getTimes() {
        return times;
    }

    public static class InvalidTimesException extends RuntimeException {
        public InvalidTimesException(String ErrorMessage) {
            super(ErrorMessage);
        }
    }
}
