package UI.LogIn;

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

    public void Login(ActionEvent event) {
        System.out.println(txtRegisterEmail.getText());
        System.out.println(txtRegisterName.getText());

    }

    public void makeAccount() {
        AccountQueries account = new AccountQueries();
        account.createAccount(txtRegisterName.getText(), txtRegisterEmail.getText(), txtRegisterPassword.getText(), txtRegisterAddress.getText(), txtRegisterCity.getText());
    }


}
