package speedreading.engine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import speedreading.SR_Const;
import speedreading.gui.views.App_SpeedReading;
import speedreading.gui.views.Menu_Main;
import speedreading.gui.views.View;

import java.io.File;

public class Controller extends Application {
    public static Controller main;

    public static void setFile(File file) {
        Controller.file = file;
    }

    private static File file;
    private static Stage mainStage;
    private View currentView;

    public static void createReader() {
        View view = new App_SpeedReading();
        SpeedReader sr = new SpeedReader(view, file);

        Stage stage = new Stage();

        stage.setTitle(file.getName().substring(0, file.getName().lastIndexOf(".")));
        stage.setScene(new Scene((Pane) view, 500, 500));
        stage.show();
    }

    public View getCurrentView() {
        return currentView;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void exit() {System.exit(0);}

    public void setup() {
        main = this;

        if (file == null) {
            Stage stage = mainStage = new Stage();
            stage.setTitle(SR_Const.Strings.name);
            stage.setScene(new Scene((Pane) (currentView = new Menu_Main()), SR_Const.Numbers.width, SR_Const.Numbers.height));
            stage.setResizable(false);
            stage.show();
        } else createReader();
    }

    public static Stage getMainStage() {return mainStage;}

    @Override
    public void start(Stage primaryStage) {
        setup();
    }
}
