package UI.LogIn;

import javafx.scene.control.Alert;
import logic.AccountQueries;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import logic.AccountQueries;

public class LoginController {
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

    @FXML TextField txtLoginPassword;



    public void makeAccount(){
        AccountQueries account = new AccountQueries();

        boolean succeeded = account.createAccount(txtRegisterName.getText(),txtRegisterEmail.getText(),txtRegisterPassword.getText(),txtRegisterAddress.getText(),txtRegisterCity.getText());

        if(succeeded){
            new Alert(Alert.AlertType.INFORMATION,"Account created.").show();
        } else {
            new Alert(Alert.AlertType.ERROR,"Failed to create an account.").show();
        }
    }

    public void loginAccount(){
        AccountQueries account = new AccountQueries();

        boolean succeeded = account.loginAccount(txtLoginEmail.getText(), txtLoginPassword.getText());

        if(succeeded){
            new Alert(Alert.AlertType.INFORMATION,"Login Successful.").show();
        } else {
            new Alert(Alert.AlertType.ERROR,"Failed to login.").show();
        }

    }


}
