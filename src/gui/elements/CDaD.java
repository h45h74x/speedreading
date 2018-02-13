package gui.elements;

import engine.SpeedReading;
import gui.views.View;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CDaD extends StackPane {
    private View parent;
    private String text;
    private ImageView imageView;
    private StackPane contentPane = this;

    public CDaD() {
        this.text = "Drop a file here to start reading!";

        setup();
    }

    private void mouseDragOver(final DragEvent e) {
        final Dragboard db = e.getDragboard();

        final boolean isAccepted = db.getFiles().get(0).getName().toLowerCase().endsWith(".png")
                || db.getFiles().get(0).getName().toLowerCase().endsWith(".jpeg")
                || db.getFiles().get(0).getName().toLowerCase().endsWith(".jpg");

        if (db.hasFiles()) {
            if (isAccepted) {
                setStyle("-fx-border-color: red;"
                        + "-fx-border-width: 5;"
                        + "-fx-background-color: #C6C6C6;"
                        + "-fx-border-style: solid;");
                e.acceptTransferModes(TransferMode.COPY);
            }
        } else {
            e.consume();
        }
    }

    void addImage(Image i, StackPane pane) {

        imageView = new ImageView();
        imageView.setImage(i);
        pane.getChildren().add(imageView);
    }

    private void mouseDragDropped(final DragEvent e) {
        final Dragboard db = e.getDragboard();
        boolean success = false;

        if (db.hasFiles()) {
            success = true;
            // Only get the first file from the list
            final File file = db.getFiles().get(0);

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    System.out.println(file.getAbsolutePath());
                    try {
                        if (!getChildren().isEmpty()) {
                            getChildren().remove(0);
                        }
                        Image img = new Image(new FileInputStream(file.getAbsolutePath()));
                        addImage(img, contentPane);
                        SpeedReading.main.getStage().setWidth(img.getWidth());
                        SpeedReading.main.getStage().setHeight(img.getHeight());
                    } catch (FileNotFoundException ex) {

                    }
                }
            });
        }
        e.setDropCompleted(success);
        e.consume();
    }

    private void setup() {
        this.parent = SpeedReading.main.getCurrentView();


        setOnDragOver(new EventHandler() {
            @Override
            public void handle(Event event) {
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
                setStyle("-fx-border-color: #C6C6C6;");
            }
        });
    }

}
