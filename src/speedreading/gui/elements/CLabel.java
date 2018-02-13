package speedreading.gui.elements;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CLabel extends Label {
    public CLabel(String text, int size) {
        super(text);
        setup(size);
    }

    public CLabel(String text) {
        super(text);
        setup(0);
    }

    public CLabel() {
        super();
        setup(0);
    }

    private void setup(int size) {
        switch (size) {
            case 1:
                setFont(Font.font("Verdana", 10));
                break;
            case 2:
                setFont(Font.font("Verdana", 20));
                break;
            case 3:
                setFont(Font.font("Verdana", FontWeight.BOLD, 20));
                break;
            default:
                setFont(Font.font("Verdana", 15));
        }
        setTextFill(Color.BLACK);
    }
}
