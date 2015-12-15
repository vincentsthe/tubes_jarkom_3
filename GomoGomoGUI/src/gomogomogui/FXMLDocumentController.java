/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomogomogui;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import org.json.JSONObject;

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Label label0_0;
    @FXML
    private Label label0_1;
    @FXML
    private Label label0_2;
    @FXML
    private Label label0_3;
    @FXML
    private Label label0_4;
    @FXML
    private Label label0_5;
    @FXML
    private Label label0_6;
    @FXML
    private Label label0_7;
    @FXML
    private Label label0_8;
    @FXML
    private Label label0_9;
    @FXML
    private Label label0_10;
    @FXML
    private Label label0_11;
    @FXML
    private Label label0_12;
    @FXML
    private Label label0_13;
    @FXML
    private Label label0_14;
    @FXML
    private Label label0_15;
    @FXML
    private Label label0_16;
    @FXML
    private Label label0_17;
    @FXML
    private Label label0_18;
    @FXML
    private Label label0_19;
    @FXML
    private Label label1_0;
    @FXML
    private Label label1_1;
    @FXML
    private Label label1_2;
    @FXML
    private Label label1_3;
    @FXML
    private Label label1_4;
    @FXML
    private Label label1_5;
    @FXML
    private Label label1_6;
    @FXML
    private Label label1_7;
    @FXML
    private Label label1_8;
    @FXML
    private Label label1_9;
    @FXML
    private Label label1_10;
    @FXML
    private Label label1_11;
    @FXML
    private Label label1_12;
    @FXML
    private Label label1_13;
    @FXML
    private Label label1_14;
    @FXML
    private Label label1_15;
    @FXML
    private Label label1_16;
    @FXML
    private Label label1_17;
    @FXML
    private Label label1_18;
    @FXML
    private Label label1_19;
    @FXML
    private Label label2_0;
    @FXML
    private Label label2_1;
    @FXML
    private Label label2_2;
    @FXML
    private Label label2_3;
    @FXML
    private Label label2_4;
    @FXML
    private Label label2_5;
    @FXML
    private Label label2_6;
    @FXML
    private Label label2_7;
    @FXML
    private Label label2_8;
    @FXML
    private Label label2_9;
    @FXML
    private Label label2_10;
    @FXML
    private Label label2_11;
    @FXML
    private Label label2_12;
    @FXML
    private Label label2_13;
    @FXML
    private Label label2_14;
    @FXML
    private Label label2_15;
    @FXML
    private Label label2_16;
    @FXML
    private Label label2_17;
    @FXML
    private Label label2_18;
    @FXML
    private Label label2_19;
    @FXML
    private Label label3_0;
    @FXML
    private Label label3_1;
    @FXML
    private Label label3_2;
    @FXML
    private Label label3_3;
    @FXML
    private Label label3_4;
    @FXML
    private Label label3_5;
    @FXML
    private Label label3_6;
    @FXML
    private Label label3_7;
    @FXML
    private Label label3_8;
    @FXML
    private Label label3_9;
    @FXML
    private Label label3_10;
    @FXML
    private Label label3_11;
    @FXML
    private Label label3_12;
    @FXML
    private Label label3_13;
    @FXML
    private Label label3_14;
    @FXML
    private Label label3_15;
    @FXML
    private Label label3_16;
    @FXML
    private Label label3_17;
    @FXML
    private Label label3_18;
    @FXML
    private Label label3_19;
    @FXML
    private Label label4_0;
    @FXML
    private Label label4_1;
    @FXML
    private Label label4_2;
    @FXML
    private Label label4_3;
    @FXML
    private Label label4_4;
    @FXML
    private Label label4_5;
    @FXML
    private Label label4_6;
    @FXML
    private Label label4_7;
    @FXML
    private Label label4_8;
    @FXML
    private Label label4_9;
    @FXML
    private Label label4_10;
    @FXML
    private Label label4_11;
    @FXML
    private Label label4_12;
    @FXML
    private Label label4_13;
    @FXML
    private Label label4_14;
    @FXML
    private Label label4_15;
    @FXML
    private Label label4_16;
    @FXML
    private Label label4_17;
    @FXML
    private Label label4_18;
    @FXML
    private Label label4_19;
    @FXML
    private Label label5_0;
    @FXML
    private Label label5_1;
    @FXML
    private Label label5_2;
    @FXML
    private Label label5_3;
    @FXML
    private Label label5_4;
    @FXML
    private Label label5_5;
    @FXML
    private Label label5_6;
    @FXML
    private Label label5_7;
    @FXML
    private Label label5_8;
    @FXML
    private Label label5_9;
    @FXML
    private Label label5_10;
    @FXML
    private Label label5_11;
    @FXML
    private Label label5_12;
    @FXML
    private Label label5_13;
    @FXML
    private Label label5_14;
    @FXML
    private Label label5_15;
    @FXML
    private Label label5_16;
    @FXML
    private Label label5_17;
    @FXML
    private Label label5_18;
    @FXML
    private Label label5_19;
    @FXML
    private Label label6_0;
    @FXML
    private Label label6_1;
    @FXML
    private Label label6_2;
    @FXML
    private Label label6_3;
    @FXML
    private Label label6_4;
    @FXML
    private Label label6_5;
    @FXML
    private Label label6_6;
    @FXML
    private Label label6_7;
    @FXML
    private Label label6_8;
    @FXML
    private Label label6_9;
    @FXML
    private Label label6_10;
    @FXML
    private Label label6_11;
    @FXML
    private Label label6_12;
    @FXML
    private Label label6_13;
    @FXML
    private Label label6_14;
    @FXML
    private Label label6_15;
    @FXML
    private Label label6_16;
    @FXML
    private Label label6_17;
    @FXML
    private Label label6_18;
    @FXML
    private Label label6_19;
    @FXML
    private Label label7_0;
    @FXML
    private Label label7_1;
    @FXML
    private Label label7_2;
    @FXML
    private Label label7_3;
    @FXML
    private Label label7_4;
    @FXML
    private Label label7_5;
    @FXML
    private Label label7_6;
    @FXML
    private Label label7_7;
    @FXML
    private Label label7_8;
    @FXML
    private Label label7_9;
    @FXML
    private Label label7_10;
    @FXML
    private Label label7_11;
    @FXML
    private Label label7_12;
    @FXML
    private Label label7_13;
    @FXML
    private Label label7_14;
    @FXML
    private Label label7_15;
    @FXML
    private Label label7_16;
    @FXML
    private Label label7_17;
    @FXML
    private Label label7_18;
    @FXML
    private Label label7_19;
    @FXML
    private Label label8_0;
    @FXML
    private Label label8_1;
    @FXML
    private Label label8_2;
    @FXML
    private Label label8_3;
    @FXML
    private Label label8_4;
    @FXML
    private Label label8_5;
    @FXML
    private Label label8_6;
    @FXML
    private Label label8_7;
    @FXML
    private Label label8_8;
    @FXML
    private Label label8_9;
    @FXML
    private Label label8_10;
    @FXML
    private Label label8_11;
    @FXML
    private Label label8_12;
    @FXML
    private Label label8_13;
    @FXML
    private Label label8_14;
    @FXML
    private Label label8_15;
    @FXML
    private Label label8_16;
    @FXML
    private Label label8_17;
    @FXML
    private Label label8_18;
    @FXML
    private Label label8_19;
    @FXML
    private Label label9_0;
    @FXML
    private Label label9_1;
    @FXML
    private Label label9_2;
    @FXML
    private Label label9_3;
    @FXML
    private Label label9_4;
    @FXML
    private Label label9_5;
    @FXML
    private Label label9_6;
    @FXML
    private Label label9_7;
    @FXML
    private Label label9_8;
    @FXML
    private Label label9_9;
    @FXML
    private Label label9_10;
    @FXML
    private Label label9_11;
    @FXML
    private Label label9_12;
    @FXML
    private Label label9_13;
    @FXML
    private Label label9_14;
    @FXML
    private Label label9_15;
    @FXML
    private Label label9_16;
    @FXML
    private Label label9_17;
    @FXML
    private Label label9_18;
    @FXML
    private Label label9_19;
    @FXML
    private Label label10_0;
    @FXML
    private Label label10_1;
    @FXML
    private Label label10_2;
    @FXML
    private Label label10_3;
    @FXML
    private Label label10_4;
    @FXML
    private Label label10_5;
    @FXML
    private Label label10_6;
    @FXML
    private Label label10_7;
    @FXML
    private Label label10_8;
    @FXML
    private Label label10_9;
    @FXML
    private Label label10_10;
    @FXML
    private Label label10_11;
    @FXML
    private Label label10_12;
    @FXML
    private Label label10_13;
    @FXML
    private Label label10_14;
    @FXML
    private Label label10_15;
    @FXML
    private Label label10_16;
    @FXML
    private Label label10_17;
    @FXML
    private Label label10_18;
    @FXML
    private Label label10_19;
    @FXML
    private Label label11_0;
    @FXML
    private Label label11_1;
    @FXML
    private Label label11_2;
    @FXML
    private Label label11_3;
    @FXML
    private Label label11_4;
    @FXML
    private Label label11_5;
    @FXML
    private Label label11_6;
    @FXML
    private Label label11_7;
    @FXML
    private Label label11_8;
    @FXML
    private Label label11_9;
    @FXML
    private Label label11_10;
    @FXML
    private Label label11_11;
    @FXML
    private Label label11_12;
    @FXML
    private Label label11_13;
    @FXML
    private Label label11_14;
    @FXML
    private Label label11_15;
    @FXML
    private Label label11_16;
    @FXML
    private Label label11_17;
    @FXML
    private Label label11_18;
    @FXML
    private Label label11_19;
    @FXML
    private Label label12_0;
    @FXML
    private Label label12_1;
    @FXML
    private Label label12_2;
    @FXML
    private Label label12_3;
    @FXML
    private Label label12_4;
    @FXML
    private Label label12_5;
    @FXML
    private Label label12_6;
    @FXML
    private Label label12_7;
    @FXML
    private Label label12_8;
    @FXML
    private Label label12_9;
    @FXML
    private Label label12_10;
    @FXML
    private Label label12_11;
    @FXML
    private Label label12_12;
    @FXML
    private Label label12_13;
    @FXML
    private Label label12_14;
    @FXML
    private Label label12_15;
    @FXML
    private Label label12_16;
    @FXML
    private Label label12_17;
    @FXML
    private Label label12_18;
    @FXML
    private Label label12_19;
    @FXML
    private Label label13_0;
    @FXML
    private Label label13_1;
    @FXML
    private Label label13_2;
    @FXML
    private Label label13_3;
    @FXML
    private Label label13_4;
    @FXML
    private Label label13_5;
    @FXML
    private Label label13_6;
    @FXML
    private Label label13_7;
    @FXML
    private Label label13_8;
    @FXML
    private Label label13_9;
    @FXML
    private Label label13_10;
    @FXML
    private Label label13_11;
    @FXML
    private Label label13_12;
    @FXML
    private Label label13_13;
    @FXML
    private Label label13_14;
    @FXML
    private Label label13_15;
    @FXML
    private Label label13_16;
    @FXML
    private Label label13_17;
    @FXML
    private Label label13_18;
    @FXML
    private Label label13_19;
    @FXML
    private Label label14_0;
    @FXML
    private Label label14_1;
    @FXML
    private Label label14_2;
    @FXML
    private Label label14_3;
    @FXML
    private Label label14_4;
    @FXML
    private Label label14_5;
    @FXML
    private Label label14_6;
    @FXML
    private Label label14_7;
    @FXML
    private Label label14_8;
    @FXML
    private Label label14_9;
    @FXML
    private Label label14_10;
    @FXML
    private Label label14_11;
    @FXML
    private Label label14_12;
    @FXML
    private Label label14_13;
    @FXML
    private Label label14_14;
    @FXML
    private Label label14_15;
    @FXML
    private Label label14_16;
    @FXML
    private Label label14_17;
    @FXML
    private Label label14_18;
    @FXML
    private Label label14_19;
    @FXML
    private Label label15_0;
    @FXML
    private Label label15_1;
    @FXML
    private Label label15_2;
    @FXML
    private Label label15_3;
    @FXML
    private Label label15_4;
    @FXML
    private Label label15_5;
    @FXML
    private Label label15_6;
    @FXML
    private Label label15_7;
    @FXML
    private Label label15_8;
    @FXML
    private Label label15_9;
    @FXML
    private Label label15_10;
    @FXML
    private Label label15_11;
    @FXML
    private Label label15_12;
    @FXML
    private Label label15_13;
    @FXML
    private Label label15_14;
    @FXML
    private Label label15_15;
    @FXML
    private Label label15_16;
    @FXML
    private Label label15_17;
    @FXML
    private Label label15_18;
    @FXML
    private Label label15_19;
    @FXML
    private Label label16_0;
    @FXML
    private Label label16_1;
    @FXML
    private Label label16_2;
    @FXML
    private Label label16_3;
    @FXML
    private Label label16_4;
    @FXML
    private Label label16_5;
    @FXML
    private Label label16_6;
    @FXML
    private Label label16_7;
    @FXML
    private Label label16_8;
    @FXML
    private Label label16_9;
    @FXML
    private Label label16_10;
    @FXML
    private Label label16_11;
    @FXML
    private Label label16_12;
    @FXML
    private Label label16_13;
    @FXML
    private Label label16_14;
    @FXML
    private Label label16_15;
    @FXML
    private Label label16_16;
    @FXML
    private Label label16_17;
    @FXML
    private Label label16_18;
    @FXML
    private Label label16_19;
    @FXML
    private Label label17_0;
    @FXML
    private Label label17_1;
    @FXML
    private Label label17_2;
    @FXML
    private Label label17_3;
    @FXML
    private Label label17_4;
    @FXML
    private Label label17_5;
    @FXML
    private Label label17_6;
    @FXML
    private Label label17_7;
    @FXML
    private Label label17_8;
    @FXML
    private Label label17_9;
    @FXML
    private Label label17_10;
    @FXML
    private Label label17_11;
    @FXML
    private Label label17_12;
    @FXML
    private Label label17_13;
    @FXML
    private Label label17_14;
    @FXML
    private Label label17_15;
    @FXML
    private Label label17_16;
    @FXML
    private Label label17_17;
    @FXML
    private Label label17_18;
    @FXML
    private Label label17_19;
    @FXML
    private Label label18_0;
    @FXML
    private Label label18_1;
    @FXML
    private Label label18_2;
    @FXML
    private Label label18_3;
    @FXML
    private Label label18_4;
    @FXML
    private Label label18_5;
    @FXML
    private Label label18_6;
    @FXML
    private Label label18_7;
    @FXML
    private Label label18_8;
    @FXML
    private Label label18_9;
    @FXML
    private Label label18_10;
    @FXML
    private Label label18_11;
    @FXML
    private Label label18_12;
    @FXML
    private Label label18_13;
    @FXML
    private Label label18_14;
    @FXML
    private Label label18_15;
    @FXML
    private Label label18_16;
    @FXML
    private Label label18_17;
    @FXML
    private Label label18_18;
    @FXML
    private Label label18_19;
    @FXML
    private Label label19_0;
    @FXML
    private Label label19_1;
    @FXML
    private Label label19_2;
    @FXML
    private Label label19_3;
    @FXML
    private Label label19_4;
    @FXML
    private Label label19_5;
    @FXML
    private Label label19_6;
    @FXML
    private Label label19_7;
    @FXML
    private Label label19_8;
    @FXML
    private Label label19_9;
    @FXML
    private Label label19_10;
    @FXML
    private Label label19_11;
    @FXML
    private Label label19_12;
    @FXML
    private Label label19_13;
    @FXML
    private Label label19_14;
    @FXML
    private Label label19_15;
    @FXML
    private Label label19_16;
    @FXML
    private Label label19_17;
    @FXML
    private Label label19_18;
    @FXML
    private Label label19_19;
    
    private HashMap<Integer,String> playerImg ;
    private boolean myTurn;
    private int currentTurn;
    private int turn;
    private int myId;
    private ArrayList<Pair<Integer,String>> players = new ArrayList<>();
    private ArrayList<Pair<Integer,Integer>> filled = new ArrayList<>();
    private ObservableList<Pair<Integer,String>> allData = FXCollections.observableArrayList();
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private GridPane GridPane;
    @FXML
    private TableView<Pair<Integer,String>> TableView;
    @FXML
    private TableColumn<Pair<Integer,String>, Integer> Turn;
    @FXML
    private TableColumn<Pair<Integer,String>, String> Name;
    @FXML
    private Label nowTurn;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    List<List<Boolean>> marked;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BackgroundImage myBI= new BackgroundImage(new Image("gomogomogui/playbackground.jpg",1000,700,false,true),
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        AnchorPane.setBackground(new Background(myBI));
        BackgroundImage myGP= new BackgroundImage(new Image("gomogomogui/background.jpg",1000,700,false,true),
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        GridPane.setBackground(new Background(myGP));
        
        
        marked = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            marked.add(new ArrayList<>());
            for (int j = 0; j < 20; j++) {
                marked.get(i).add(false);
            }
        }
        
        myId = 1;
        turn = 1;
        currentTurn = 1;
        
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            
        }
        System.out.println("requesting player");
        List<String> playerList = Connection.listRoomPlayer(Variable.currentRoom);
        System.out.println("accepting player");
        System.out.println(playerList.size());
        
        for (int i = 0; i < playerList.size(); i++) {
            players.add(new Pair(i+1, playerList.get(i)));
        }
        System.out.println("done adding player");
        
        String now = Integer.toString(currentTurn);
        nowTurn.setText(now);
        
        Turn.setCellValueFactory(new PropertyValueFactory<>("first"));
        Name.setCellValueFactory(new PropertyValueFactory<>("second"));
        allData = TableView.getItems();
        
        for(int i=0;i<players.size();i++){
            if (players.get(i).getFirst() == myId){
                String temp = players.get(i).getSecond()+ " (You)";
                players.get(i).setFirst(turn);
                turn++;
                allData.add(players.get(i));
            }
            else{
                allData.add(players.get(i));
            }
        }
        playerImg = new HashMap<>();
        playerImg.put(0, "donald.png");
        playerImg.put(1, "goofy.png");
        playerImg.put(2, "daisy.png");
        playerImg.put(3, "mickey.png");
        playerImg.put(4, "minnie.png");
        playerImg.put(5, "stitch.png");
        playerImg.put(6, "tigger.png");
        
        updateBoardContiniously();
    }

    @FXML
    private void addPic(MouseEvent event) {
        Label a = (Label)event.getSource();
        int x = GridPane.getRowIndex(a);
        int y = GridPane.getColumnIndex(a);
        Connection.move(x, y);
        
        updatePlayerList();   
    }
    
    private void updateBoardContiniously() {
        (new Thread() {
            @Override
            public void run() {
                boolean done = false;
                while (true) {
                    try {
                        String response = Connection.requestBoard(Variable.currentRoom);
                        JSONObject jsonResponse = new JSONObject(response);
                        System.out.println(jsonResponse.toString());

                        if (jsonResponse.getString("message_type").equals("board")) {
                            Gson gson = new Gson();
                            Board board = gson.fromJson(new JSONObject(response).get("message").toString(), Board.class);
                            Platform.runLater(() -> {
                                try {
                                    nowTurn.setText(jsonResponse.getString("turn"));
                                } catch (Exception e) {
                                    
                                }
                            });

                            updateBoard(board);
                        } else if (jsonResponse.getString("message_type").equals("winner") && !done) {
                            done = true;
                            String winner = jsonResponse.getString("message");
                            Platform.runLater(() -> {
                                System.out.println(Variable.username + " " + winner);
                                if (Variable.username.equals(winner)) {
                                    winMessage();
                                } else {
                                    loseMessage();
                                }
                            });
                        }
                        Thread.sleep(400);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }).start();
    }
    
    private void updateBoard(Board board) {
        int size = board.getBoardSize();
        System.out.println("updating board");
        
        Platform.runLater(() -> {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int playerNumber = board.getTileAtPosition(i, j);
                    if ((playerNumber != -1) && (marked.get(i).get(j) == false)) {
                        marked.get(i).set(j, true);
                        Label label = new Label();
                        Pair<Integer,Integer> checkFilled = new Pair(1, 3);

                        filled.add(checkFilled);

                        Image img= new Image(getClass().getResourceAsStream(playerImg.get(playerNumber)));
                        ImageView IV = new ImageView(img);
                        IV.setStyle("-fx-alignment: Center;");
                        IV.setFitHeight(30.0);
                        IV.setFitWidth(30.0);
                        label.setGraphic(IV);
                        GridPane.add(label, j, i);
                    }
                }
            }
        });
    }
    
    private void updatePlayerList(){
        for(int i=0;i<allData.size();i++){
            if (players.get(i).getFirst() == currentTurn){
                players.get(i).setFirst(currentTurn+allData.size());
                allData.set(i, players.get(i));
            } 
        }
        currentTurn++;
        String now = Integer.toString(currentTurn);
        nowTurn.setText(now);
    }
    
    private void updatePlayerList(Board board, Label a) {
        updatePlayerList();
        
        int size = board.getBoardSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Image img= new Image(getClass().getResourceAsStream(playerImg.get(myId)));
                ImageView IV = new ImageView(img);
                IV.setStyle("-fx-alignment: Center;");
                IV.setFitHeight(a.getPrefHeight());
                IV.setFitWidth(a.getPrefWidth());
                a.setGraphic(IV);
            }
        }
    }
    
    private void setOtherPlayerMove(int player_id, int x, int y){
        filled.add(new Pair(x,y));
        playerImg.get(player_id);
        if(player_id == myId){
            
        }
    }
    
    private void currentPlayer(int player_id){
        if (myId == player_id){
            myTurn = true;
        }
    }
    
    private void setMyId(int player_id){
        myId = player_id;
    }
    
    private void playerDisconnect(int player_id){
//        for (String dat: data){
//            if ((Integer)data.getFirst() == player_id){
//                players.remove(player);
//            }
//        }
//        for (int i = 0;i<data.size();i++){
//            if (dummydata.get(i) == player_id ){
//                data.remove(i);
//                dummydata.remove(i);
//            }
//        }
    }
    
    private void setWinner(int player_id){
        
    }
    
    private void winMessage(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("Congratulations!!!");
        alert.setContentText("You Win!!");
        alert.showAndWait();
    }

    private void loseMessage(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("Try again!!");
        alert.setContentText("You Lose!!");
        alert.showAndWait();
    }
    
    
}
