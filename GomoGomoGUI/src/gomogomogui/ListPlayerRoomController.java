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
public class ListPlayerRoomController implements Initializable {
    private TableView table;
    @FXML
    private Button startButton;
    @FXML
    private Button backButton;
    @FXML
    private TableView<Pair<Integer,String>> tablePlayer;
    @FXML
    private TableColumn<Pair<Integer, String>, Integer> number;
    @FXML
    private TableColumn<Pair<Integer, String>, String> listPlayerName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Pair<Integer, String> player1 = new Pair(1, "aaa");
        Pair<Integer, String> player2 = new Pair(2, "bbb");
        Pair<Integer, String> player3 = new Pair(3, "ccc");
        Pair<Integer, String> player4 = new Pair(4, "ddd");
        Pair<Integer, String> player5 = new Pair(5, "eee");
        Pair<Integer, String> player6 = new Pair(6, "fff");
        Pair<Integer, String> player7 = new Pair(7, "ggg");
        
        number.setCellValueFactory(new PropertyValueFactory<>("first"));
        listPlayerName.setCellValueFactory(new PropertyValueFactory<>("second"));
        ObservableList<Pair<Integer,String>> allData = tablePlayer.getItems();
        allData.add(player1);
        allData.add(player2);
        allData.add(player3);
        allData.add(player4);
        allData.add(player5);
        allData.add(player6);
        allData.add(player7);
    }    

    @FXML
    private void startButtonAction(ActionEvent event) {
    }

    @FXML
    private void backButtonAction(ActionEvent event) throws IOException {
      ((Node) (event.getSource())).getScene().getWindow().hide();
      Parent parent = FXMLLoader.load(getClass().getResource("Menu.fxml"));  
      
      Stage stage = (Stage) tablePlayer.getScene().getWindow();
      Scene scene  = new Scene(parent);
      stage.setScene(scene);
      stage.setTitle("Menu");
      stage.show();
    }
    
}
