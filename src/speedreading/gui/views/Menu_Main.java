package speedreading.gui.views;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import speedreading.SR_Const;
import speedreading.engine.Controller;
import speedreading.gui.elements.CBotBar;
import speedreading.gui.elements.CBrowse;
import speedreading.gui.elements.CDaD;
import speedreading.gui.elements.CLabel;

import java.io.File;


public class Menu_Main extends BorderPane implements Menu {
    private CBrowse browse;
    private CBotBar botBar;

    public Menu_Main() {
        setupGUI();
    }

    public Menu setupGUI() {
        botBar = new CBotBar(this, "Exit", "Start");
        botBar.toggleButton(1, false);

        setCenter(createCenter());
        setBottom(botBar);
        setPadding(new Insets(15, 10, 10, 10));
        return this;
    }

    private VBox createCenter() {
        VBox center = new VBox();

        CDaD dad = new CDaD(this);
        dad.setPrefHeight(SR_Const.Numbers.panelheight);

        CLabel label = new CLabel("Choose your file");
        //label.setTextFill(Color.web("#6ba2ff"));

        browse = new CBrowse(this);
        browse.setPrefHeight(200);

        Separator separator = new Separator();
        separator.setOrientation(Orientation.HORIZONTAL);

        center.getChildren().addAll(label, dad, separator, browse);

        center.setSpacing(20);

        return center;
    }

    @Override
    public void back() {
        Controller.exit();
    }

    @Override
    public void next() {
        Controller.createReader();
    }

    public void setFile(File file) {
        Controller.setFile(file);
        browse.setFile(file);
        botBar.toggleButton(1, true);
        botBar.paintButton(1);
    }
}
