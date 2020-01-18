package UI.Controllers;

import data.Account;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import logic.AccountQueries;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginViewController {
    @FXML
    private TextField txtRegisterEmail;

    @FXML
    private TextField txtRegisterName;

    @FXML
    private PasswordField txtRegisterPassword;

    @FXML
    private TextField txtRegisterAddress;

    @FXML
    private TextField txtRegisterCity;

    @FXML
    private TextField txtLoginEmail;

    @FXML
    private TextField txtLoginPassword;

    public void makeAccount() {
        AccountQueries account = new AccountQueries();
        boolean succeeded = account.createAccount(txtRegisterName.getText(),txtRegisterEmail.getText(),txtRegisterPassword.getText(),txtRegisterAddress.getText(),txtRegisterCity.getText());

        if(succeeded){
            new Alert(Alert.AlertType.INFORMATION,"Account created.").show();

        } else {
            new Alert(Alert.AlertType.ERROR,"Failed to create an account.").show();
        }

    }


    public void loginAccount(ActionEvent event) throws IOException{
        AccountQueries account = new AccountQueries();
            if (!txtLoginEmail.getText().isEmpty() || !txtLoginPassword.getText().isEmpty()){
                boolean succeeded = account.loginAccount(txtLoginEmail.getText(), txtLoginPassword.getText());
                if(succeeded){
                    new Alert(Alert.AlertType.INFORMATION,"Login Successful.").show();
                    Parent AccountView = FXMLLoader.load(getClass().getResource("AccountView.fxml"));
                    Scene AccountScene = new Scene(AccountView);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(AccountScene);
                    window.show();
                } else {
                    new Alert(Alert.AlertType.ERROR,"Failed to login.").show();
                }
            }
        }
    }
