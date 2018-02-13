package speedreading.gui.elements;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class CButton extends Button {
    private String text;

    public CButton() {
        super();
    }

    public CButton(String text) {
        super();
        changeText(text);
    }

    public CButton(String text, EventHandler<ActionEvent> e) {
        super();
        changeText(text);
        setOnAction(e);
    }

    public void changeText(String text) {
        setText(text);
        this.text = text;
    }
}
