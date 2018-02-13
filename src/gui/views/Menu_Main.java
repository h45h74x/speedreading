package gui.views;

import gui.elements.CBotBar;
import gui.elements.CButton;
import gui.elements.CDaD;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Menu_Main extends BorderPane implements View {

    public Menu_Main() {
        CBotBar botBar = new CBotBar();
        CDaD btn = new CDaD();

        setCenter(btn);
        setBottom(botBar);
    }

    @Override
    public void back() {

    }

    @Override
    public void next() {

    }
}
