package UI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AccountViewController {

    @FXML
    private void showLogin(ActionEvent event) throws IOException {
        Parent newView = FXMLLoader.load(getClass().getResource("LoginView.fxml"));

        Scene newScene = new Scene(newView);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void showProfileQueries(ActionEvent event) throws IOException {
        Parent AccountView = FXMLLoader.load(getClass().getResource("ProfileQueries.fxml"));

        Scene AccountScene = new Scene(AccountView);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(AccountScene);
        window.show();
    }

    @FXML
    private void showAccountSettings(ActionEvent event) throws IOException {
        Parent newView = FXMLLoader.load(getClass().getResource("AccountSettings.fxml"));

        Scene newScene = new Scene(newView);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void showProfileSettings(ActionEvent event) throws IOException {
        Parent newView = FXMLLoader.load(getClass().getResource("ProfileSettings.fxml"));

        Scene newScene = new Scene(newView);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
}
