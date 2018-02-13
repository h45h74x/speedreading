package gui.elements;

import engine.SpeedReading;
import gui.views.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;

public class CBotBar extends BorderPane {
    private View parent;
    private String left, right;
    private CButton bt_left, bt_right;

    public CBotBar(String left, String right) {
        super();
        this.left = left;
        this.right = right;

        setup();
    }

    public CBotBar() {
        super();
        this.left = "Back";
        this.right = "Next";

        setup();
    }

    private void setup() {
        this.parent = SpeedReading.main.getCurrentView();

        bt_left = new CButton(left, event ->  parent.back());
        bt_right = new CButton(right, event -> parent.next());

        setLeft(bt_left);
        setRight(bt_right);
    }
}
