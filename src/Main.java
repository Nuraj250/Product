import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = (Parent) FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                "view/Product.fxml")));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Library");
        stage.getMaxWidth();
        stage.show();
    }
}
