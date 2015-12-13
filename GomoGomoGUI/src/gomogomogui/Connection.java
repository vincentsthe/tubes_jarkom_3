/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomogomogui;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author vincentsthe
 */
public class Connection {
    
    private static Socket socket;
    
    private static OutputStream out;
    
    private static DataOutputStream os;
    
    private static InputStream in;
    
    private static DataInputStream is;
    
    public static void initialize(Socket socket) {
        try {
            socket = socket;
            out = socket.getOutputStream();
            os = new DataOutputStream(out);
            in = socket.getInputStream();
            is = new DataInputStream(in);
            System.out.println("Connection estabished");
        } catch (Exception e) {
            System.out.println("Error connecting to host");
        }
    }
    
    public static void register(String username) {
        try {
            JSONObject json = new JSONObject();
            json.put("message_type", "register");
            json.put("message", username);
            
            sendMessage(json.toString());
        } catch (Exception e) {
            System.out.println("Json error");
        }
    }
    
    public static void createRoom(String roomName) {
        try {
            JSONObject json = new JSONObject();
            json.put("message_type", "create_room");
            json.put("message", roomName);
            
            sendMessage(json.toString());
        } catch (Exception e) {
            System.out.println("Json error");
        }
    }
    
    public static List<String> getAllRoom() {
        try {
            JSONObject json = new JSONObject();
            json.put("message_type", "list_room");
            
            sendMessage(json.toString());
            
            String response = new JSONObject(readMessage()).getString("message");
            Type listType = new TypeToken<List<String>>() {}.getType();
            List<String> roomList = new Gson().fromJson(response, listType);
            
            return roomList;
        } catch (Exception e) {
            System.out.println("Json error");
            return new ArrayList();
        }
    }
    
    public static void joinRoom(String roomName) {
        try {
            JSONObject json = new JSONObject();
            json.put("message_type", "join_room");
            json.put("message", roomName);
            
            sendMessage(json.toString());
        } catch (Exception e) {
            System.out.println("Json error");
        }
    }
    
    public static List<String> listRoomPlayer(String roomName) {
        try {
            JSONObject json = new JSONObject();
            json.put("message_type", "list_player_room");
            json.put("message", roomName);
            
            sendMessage(json.toString());
            
            String message = readMessage();
            System.out.println(message);
            String response = new JSONObject(message).getString("message");
            Type listType = new TypeToken<List<String>>() {}.getType();
            List<String> playerList = new Gson().fromJson(response, listType);
            
            return playerList;
        } catch (Exception e) {
            System.out.println("Json error");
            return new ArrayList();
        }
    }
    
    public static void startRoom(String roomName) {
        try {
            JSONObject json = new JSONObject();
            json.put("message_type", "start_room");
            json.put("message", roomName);
            
            sendMessage(json.toString());
        } catch (Exception e) {
            System.out.println("Json error");
        }
    }
    
    public static void waitForStart() {
        try {
            String response = readMessage();
            System.out.println("should be game start");
            System.out.println(response);
        } catch (Exception e) {
            System.out.println("JSON error");
        }
    }
    
    public static Board requestBoard(String roomName) {
        try {
            JSONObject json = new JSONObject();
            json.put("message_type", "request_board");
            json.put("message", roomName);
            
            sendMessage(json.toString());
            
            String response = readMessage();
            Board board = (new Gson()).fromJson(response, Board.class);
            
            return board;
        } catch (Exception e) {
            System.out.println("Json error");
            return null;
        }
    }
    
    public static Board waitForBoard() {
        try {
            String response = readMessage();
            Gson gson = new Gson();
            Board board = gson.fromJson(new JSONObject(response).get("message").toString(), Board.class);
            return board;
        } catch (Exception e) {
            System.out.println("JSON error");
            return null;
        }
    }
    
    public static void move(int y, int x) {
        try {
            JSONObject json = new JSONObject();
            json.put("message_type", "move");
            
            JSONObject coordinate = new JSONObject();
            coordinate.put("x", x);
            coordinate.put("y", y);
            json.put("message", coordinate.toString());
            
            sendMessage(json.toString());
        } catch (Exception e) {
            System.out.println("Json error");
        }
    }
    
    private static synchronized void sendMessage(String message) {
        try {
            System.out.println("Sending: " + message);
            
            os.writeBytes(message);
            os.writeByte('\n');
            os.flush();
        } catch(IOException e) {
            System.out.println("Error contacting server....");
        }
    }
    
    private static String readMessage() {
        System.out.println("Listening");
        String s;
        try {
            s = is.readLine();
        } catch (IOException e) {
            s = "";
        }
        System.out.println("Done listening");
        return s;
    }
}
