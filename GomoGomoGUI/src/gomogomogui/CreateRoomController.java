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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jessica
 */
public class CreateRoomController implements Initializable {
    
    @FXML
    private TextField roomName;
    @FXML
    private Button createRoom;
    @FXML
    private Button backButton;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goToMenuAction(ActionEvent event) throws IOException {
      ((Node) (event.getSource())).getScene().getWindow().hide();
      Parent parent = FXMLLoader.load(getClass().getResource("Menu.fxml"));  
      
      Stage stage = (Stage) roomName.getScene().getWindow();
      Scene scene  = new Scene(parent);
      stage.setScene(scene);
      stage.setTitle("Menu");
      stage.show();
    }

    @FXML
    private void goToCreateAction(ActionEvent event) {
    }
    
}
