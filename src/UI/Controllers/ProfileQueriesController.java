package UI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfileQueriesController {

    @FXML
    private void showAccountOverview(ActionEvent event) throws IOException {
        Parent newView = FXMLLoader.load(getClass().getResource("AccountView.fxml"));

        Scene newScene = new Scene(newView);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
}
