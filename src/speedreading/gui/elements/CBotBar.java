package speedreading.gui.elements;

import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import speedreading.gui.views.Menu;

public class CBotBar extends BorderPane {
    private Menu parent;
    private String left, right;
    private CButton bt_left, bt_right;

    public CBotBar(Menu parent, String left, String right) {
        super();
        this.left = left;
        this.right = right;

        setup(parent);
    }

    public CBotBar(Menu parent) {
        super();
        this.left = "Back";
        this.right = "Next";

        setup(parent);
    }

    public void toggleButton(int index, boolean active) {
        switch (index) {
            case 0:
                bt_left.setDisable(!active);
                break;
            case 1:
                bt_right.setDisable(!active);
                break;
        }
    }

    public void paintButton(int index) {
        String temp = "-fx-base: rgba(61, 229, 89, 0.89);";
        switch (index) {
            case 0:
                bt_left.setStyle(temp);
                break;
            case 1:
                bt_right.setStyle(temp);
                break;
        }
    }

    private void setup(Menu parent) {
        this.parent = parent;

        bt_left = new CButton(left, event -> back());
        bt_left.setPrefWidth(200);

        bt_right = new CButton(right, event -> next());
        bt_right.setPrefWidth(200);

        setLeft(bt_left);
        setRight(bt_right);
    }

    private void back() {
        parent.back();
    }

    private void next() {
        parent.next();
    }
}
