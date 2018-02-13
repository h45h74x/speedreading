package speedreading.gui.elements;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import speedreading.SR_Const;
import speedreading.engine.Controller;
import speedreading.gui.views.Menu_Main;
import speedreading.gui.views.View;

import java.awt.*;
import java.io.File;

public class CDaD extends StackPane {
    private Menu_Main parent;

    private String active = "-fx-border-color: #68a2ff;"
            + "-fx-border-width: 3;"
            + "-fx-background-color: #c9e6ff;"
            + "-fx-border-style: solid;";

    private String sleeping = "-fx-border-color: #68a2ff;"
            + "-fx-border-width: 1;"
            + "-fx-background-color: #e2f2ff;"
            + "-fx-border-style: solid;";

    public CDaD() {
        setup();
    }

    public CDaD(Menu_Main parent) {
        this.parent = parent;
        setup();
    }

    private void setup() {
        setStyle(sleeping);

        CLabel l = new CLabel("Drag here", 1);
        l.setTextFill(Color.web("#68a2ff"));
        getChildren().add(l);

        setOnDragOver(new EventHandler() {
            @Override
            public void handle(Event event) {
                setStyle(active);
                mouseDragOver((DragEvent) event);
            }
        });

        setOnDragDropped(new EventHandler() {
            @Override
            public void handle(Event event) {
                mouseDragDropped((DragEvent) event);
            }
        });

        setOnDragExited(new EventHandler() {
            @Override
            public void handle(Event event) {
                setStyle(sleeping);
            }
        });
    }

    private void mouseDragDropped(final DragEvent e) {
        final Dragboard db = e.getDragboard();
        boolean success = false;

        if (db.hasFiles()) {
            success = true;
            File file = db.getFiles().get(0);

            Platform.runLater(() -> passFile(file));
        }

        e.setDropCompleted(success);
        e.consume();
    }

    private void mouseDragOver(final DragEvent e) {
        final Dragboard db = e.getDragboard();



        boolean isAccepted = false;
        for (int i = 0; i< SR_Const.Strings.allowedFiles.length; i++)
            isAccepted |= db.getFiles().get(0).getName().toLowerCase().endsWith(SR_Const.Strings.allowedFiles[i].substring(1));

        if (db.hasFiles()) {
            if (isAccepted) {
                setStyle(active);
                e.acceptTransferModes(TransferMode.COPY);
            }
        } else {
            e.consume();
        }
    }

    private void passFile(File file) {
        parent.setFile(file);
    }
}
