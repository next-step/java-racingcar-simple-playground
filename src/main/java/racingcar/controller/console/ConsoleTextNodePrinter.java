package racingcar.controller.console;


import java.util.List;
import racingcar.view.text.TextView;


public class ConsoleTextNodePrinter {

    public void print(TextView node) {
        if (node instanceof TextView.Leaf leaf) {
            print(leaf);
        } else if (node instanceof TextView.Sections sections) {
            print(sections);
        }
    }


    private void print(TextView.Leaf leaf) {
        for (String line : leaf.getLines()) {
            System.out.println(line);
        }
    }

    private void print(TextView.Sections sections) {
        List<TextView> content = sections.getContent();
        for (TextView section : content) {
            System.out.println();
            print(section);
        }
    }

}
