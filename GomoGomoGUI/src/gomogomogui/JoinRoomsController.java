/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomogomogui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author Jessica
 */
public class JoinRoomsController implements Initializable {
    @FXML
    private Button backButton;
    @FXML
    private TableView<Pair<String,Integer>> tableRoom;
    @FXML
    private TableColumn<Pair<String, Integer>, String> roomName;
    @FXML
    private TableColumn<Pair<String, Integer>, Integer> numberPlayer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Pair<String, Integer> player1 = new Pair("Room1", "1");
        Pair<String, Integer> player2 = new Pair("Room2", "2");
        Pair<String, Integer> player3 = new Pair("Room3", "3");
        Pair<String, Integer> player4 = new Pair("Room4", "4");
        Pair<String, Integer> player5 = new Pair("Room5", "5");
        Pair<String, Integer> player6 = new Pair("Room6", "2");
        Pair<String, Integer> player7 = new Pair("Room7", "1");
        
        roomName.setCellValueFactory(new PropertyValueFactory<>("first"));
        numberPlayer.setCellValueFactory(new PropertyValueFactory<>("second"));
        ObservableList<Pair<String,Integer>> allData = tableRoom.getItems();
        allData.add(player1);
        allData.add(player2);
        allData.add(player3);
        allData.add(player4);
        allData.add(player5);
        allData.add(player6);
        allData.add(player7);
    }    

    @FXML
    private void backButtonAction(ActionEvent event) throws IOException {
      ((Node) (event.getSource())).getScene().getWindow().hide();
      Parent parent = FXMLLoader.load(getClass().getResource("Menu.fxml"));  
      
      Stage stage = (Stage) backButton.getScene().getWindow();
      Scene scene  = new Scene(parent);
      stage.setScene(scene);
      stage.setTitle("Menu");
      stage.show();
    }
    
}
