/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomogomogui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Jessica
 */
public class HomeController implements Initializable {
    @FXML
    private Label playerName;
    @FXML
    private TextField nickName;
    @FXML
    private Label goToMenu;

    @FXML
    private void goToMenuAction(MouseEvent event) throws IOException {
      ((Node) (event.getSource())).getScene().getWindow().hide();
      Parent parent = FXMLLoader.load(getClass().getResource("Menu.fxml"));  
    
      Stage stage = (Stage) nickName.getScene().getWindow();
      
      String username = nickName.getText();
      Variable.username = username;
      Connection.register(username);
      
      Scene scene  = new Scene(parent);
      stage.setScene(scene);
      stage.setTitle("Menu");
      stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
