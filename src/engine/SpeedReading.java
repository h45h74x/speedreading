package engine;

import gui.elements.CButton;
import gui.views.Menu_Main;
import gui.views.View;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SpeedReading extends Application {
    public static SpeedReading main;
    private View currentView;
    private Stage stage;

    public Stage getStage() {
        return stage;
    }

    public View getCurrentView() {
        return currentView;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        main = this;
        stage = primaryStage;

        primaryStage.setTitle("SpeedReading");


        primaryStage.setScene(new Scene(new Menu_Main(), 300, 250));
        primaryStage.show();
    }
}
