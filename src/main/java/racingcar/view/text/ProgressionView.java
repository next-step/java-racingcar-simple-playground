package racingcar.view.text;

import java.util.List;
import racingcar.domain.CarRacing;


/**
 * 자동차 경주에서, 한 회차 이후의 상태를 보여줍니다.
 * <p>
 * 한번 차를 전진시킨 후에는 차의 위치와 같은 정보를 보여주기 위해 저장해야 하는데, 해당 정보가 이 클래스에 저장되어 있습니다.
 */
public class ProgressionView implements TextView.Leaf {

    private final List<CarRacing.CarProgression> cars;

    public ProgressionView(List<CarRacing.CarProgression> cars) {
        this.cars = cars;
    }

    @Override
    public List<String> getLines() {
        return cars.stream()
                .map(this::getLine)
                .toList();
    }

    private String getLine(CarRacing.CarProgression car) {
        StringBuilder str = new StringBuilder();
        str.append(car.getName());
        str.append(" : ");

        for (int i = 0; i < car.position(); i++) {
            str.append("-");
        }

        return str.toString();
    }

}
