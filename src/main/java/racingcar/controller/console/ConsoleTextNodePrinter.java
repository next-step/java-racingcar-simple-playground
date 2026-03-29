package racingcar.controller.console;


import java.util.List;
import racingcar.view.text.TextNode;


public class ConsoleTextNodePrinter {

    public void print(TextNode node) {
        if (node instanceof TextNode.Leaf leaf) {
            print(leaf);
        } else if (node instanceof TextNode.Sections sections) {
            print(sections);
        }
    }


    private void print(TextNode.Leaf leaf) {
        for (String line : leaf.lines()) {
            System.out.println(line);
        }
    }

    private void print(TextNode.Sections sections) {
        List<TextNode> content = sections.content();
        for (TextNode section : content) {
            System.out.println();
            print(section);
        }
    }

}
