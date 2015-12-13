/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomogomogui;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jessica
 */
public class Home extends Application {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 6004;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Home");
        stage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(HOST, PORT);

            Connection.initialize(socket);
            System.out.println("mulai");
            
//            Listener listener = new Listener(socket);
//            listener.start();

            launch(args);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

class Listener extends Thread {
    
    private Socket socket;
    
    private static InputStream in;
    
    private static DataInputStream is;
    
    public Listener(Socket socket) {
        this.socket = socket;
        try {
            in = socket.getInputStream();
            is = new DataInputStream(in);
        } catch (IOException e) {
            System.out.println("Error listening to server...");
        }
    }
    
    
    
    @Override
    public void run() {
        
        String line;
        try {
            while (true) {
                line = is.readLine();
                System.out.println("===== listener ======");
                System.out.println("line");
            }
        } catch (IOException e) {
            System.out.println("Error listening to server...");
        }
    }
}