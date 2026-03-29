package racingcar.view.text;

import java.util.List;


public sealed interface TextView {

    non-sealed interface Leaf extends TextView {

        List<String> getLines();

    }

    non-sealed interface Sections extends TextView {

        List<TextView> getContent();

    }

}
