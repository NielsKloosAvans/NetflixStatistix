package UI.Controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
        primaryStage.setTitle("Julius van Leeuwen - 2160926, Niels Kloos - 2160926 Twan Roelofsen - 2156992");
        primaryStage.setScene(new Scene(root, 1266, 710));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
