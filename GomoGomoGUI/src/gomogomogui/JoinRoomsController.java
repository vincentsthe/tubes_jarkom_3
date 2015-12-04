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
import javafx.collections.FXCollections;
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
    
    private ObservableList<Pair<String, Integer>> allData = FXCollections.observableArrayList();
    private ArrayList<Pair<String,Integer>> joinRooms = new ArrayList<>();
    
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
        Pair<String, Integer> room1 = new Pair("Room1", "1");
        Pair<String, Integer> room2 = new Pair("Room2", 2);
        Pair<String, Integer> room3 = new Pair("Room3", 3);
        Pair<String, Integer> room4 = new Pair("Room4", 4);
        Pair<String, Integer> room5 = new Pair("Room5", 5);
        Pair<String, Integer> room6 = new Pair("Room6", 6);
        Pair<String, Integer> room7 = new Pair("Room7", 7);
        
        joinRooms.add(room1);
        joinRooms.add(room2);
        joinRooms.add(room3);
        joinRooms.add(room4);
        joinRooms.add(room5);
        joinRooms.add(room6);
        joinRooms.add(room7);
        
        roomName.setCellValueFactory(new PropertyValueFactory<>("first"));
        numberPlayer.setCellValueFactory(new PropertyValueFactory<>("second"));
        allData = tableRoom.getItems();
        
        for(int i = 0; i < joinRooms.size(); i++){
            allData.add(joinRooms.get(i));
        }
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
