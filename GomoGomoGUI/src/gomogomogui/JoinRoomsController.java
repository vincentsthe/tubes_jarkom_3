/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomogomogui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jessica
 */
public class JoinRoomsController implements Initializable {
    
    private ObservableList<Pair<String, Integer>> allData = FXCollections.observableArrayList();
    private ArrayList<Pair<String,Integer>> joinRooms = new ArrayList<>();
    private List<String> roomList = new ArrayList<>();
    
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
        List<String> roomList = Connection.getAllRoom();
        
        for (int i = 0; i < roomList.size(); i++) {
            joinRooms.add(new Pair(roomList.get(i), i+1));
        }
        
        roomName.setCellValueFactory(new PropertyValueFactory<>("first"));
        numberPlayer.setCellValueFactory(new PropertyValueFactory<>("second"));
        allData = tableRoom.getItems();
        
        for(int i = 0; i < joinRooms.size(); i++){
            allData.add(joinRooms.get(i));
        }
        
        tableRoom.setOnMousePressed((event) -> {
            System.out.println("=================");
            String room = tableRoom.getSelectionModel().getSelectedItem().getFirst();
            Connection.joinRoom(room);
            Variable.currentRoom = room;

            try {
                ((Node) (event.getSource())).getScene().getWindow().hide();
                Parent parent = FXMLLoader.load(getClass().getResource("ListPlayerRoom.fxml"));  

                Stage stage = (Stage) backButton.getScene().getWindow();
                Scene scene  = new Scene(parent);
                stage.setScene(scene);
                stage.setTitle("List Player");
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();;
            }
        });
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
