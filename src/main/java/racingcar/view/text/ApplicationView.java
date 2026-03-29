package racingcar.view.text;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.CarRacing;


public class ApplicationView implements TextView.Sections {

    private final List<ProgressionView> progressions;
    private final GameResultView result;

    public ApplicationView(CarRacing.GameResult result) {
        this.progressions = result.progressions().stream()
                .map(progression -> new ProgressionView(progression.cars()))
                .toList();

        this.result = new GameResultView(result.winners());
    }

    @Override
    public List<TextView> getContent() {
        List<TextView> nodes = new ArrayList<>();
        nodes.addAll(progressions);
        nodes.add(result);
        return nodes;
    }

}
