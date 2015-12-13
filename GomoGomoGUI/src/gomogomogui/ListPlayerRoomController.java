/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomogomogui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
        
        number.setCellValueFactory(new PropertyValueFactory<>("first"));
        listPlayerName.setCellValueFactory(new PropertyValueFactory<>("second"));
        ObservableList<Pair<Integer,String>> allData = tablePlayer.getItems();
        
        List<String> playerList = Connection.listRoomPlayer(Variable.currentRoom);
        
        for (int i = 0; i < playerList.size(); i++) {
            allData.add(new Pair(i+1, playerList.get(i)));
        }
        
        (new Thread() {
            @Override
            public void run() {
                Connection.waitForStart();
                Platform.runLater(() -> {
                    try {
                        System.out.println("starting...");
                        Parent parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));  

                        Connection.startRoom(Variable.currentRoom);

                        Stage stage = (Stage) tablePlayer.getScene().getWindow();
                        Scene scene  = new Scene(parent);
                        stage.setScene(scene);
                        stage.setTitle("Gomo Gomo");
                        stage.show();
                    } catch (IOException e) {

                    }
                });
            }
        }).start();
    }    

    @FXML
    private void startButtonAction(ActionEvent event) throws IOException {
        System.out.println("clicked");
        Connection.startRoom(Variable.currentRoom);
        System.out.println("endd");
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
