    package racing.domain;

    import java.util.List;
    import java.util.stream.Collectors;
    public class Race {
        private final Cars cars;

        public Race(Cars cars){
            this.cars = cars;
        }
        public void playRound(MoveStrategy moveStrategy) {
            cars.moveAll(moveStrategy);
        }
        public List<Car> getParticipatingCars() {
            return cars.getCarList();
        }
        public static void validateTrialCount(int tryNumber){
            if(tryNumber <= 0){
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 1회 이상이여야합니다.");
            }
        }
        public List<String> getWinners() {
            List<Car> carList = cars.getCarList();
            int maxPosition = carList.stream()
                    .mapToInt(Car::getPosition)
                    .max()
                    .orElse(0);

            return carList.stream()
                    .filter(car -> car.getPosition() == maxPosition)
                    .map(Car::getName)
                    .collect(Collectors.toList());
        }
    }
