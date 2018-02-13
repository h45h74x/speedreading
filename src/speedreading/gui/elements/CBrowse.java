package speedreading.gui.elements;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import speedreading.SR_Const;
import speedreading.engine.Controller;
import speedreading.gui.views.Menu_Main;

import java.io.File;

public class CBrowse extends HBox {
    private TextField textField;
    private Menu_Main parent;
    private File file;

    public CBrowse(Menu_Main parent) {
        super();
        this.parent = parent;
        setup();
    }

    private void setup() {
        setPrefWidth(SR_Const.Numbers.width);

        CButton browse = new CButton("Browse", event -> openExplorer());

        textField = new TextField();
        textField.setPrefWidth(SR_Const.Numbers.width - 85);

        setSpacing(10);

        getChildren().addAll(textField, browse);
    }

    private void openExplorer() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Text File");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files", SR_Const.Strings.allowedFiles);
        fileChooser.getExtensionFilters().add(extFilter);

        if (this.file != null) fileChooser.setInitialDirectory(new File(file.getParent()));

        File file = fileChooser.showOpenDialog(Controller.getMainStage());
        passFile(file);
    }

    private void passFile(File file) {
        if (file == null) return;
        parent.setFile(file);
    }

    public void setFile(File file) {
        textField.setText(file.getAbsolutePath());
    }
}
