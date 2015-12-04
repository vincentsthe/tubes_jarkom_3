package server;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;

public class PlayerThread extends Thread {

    private Socket connection;

    private int playerNumber;

    private boolean connected;

    private Game game;

    private DataOutputStream out;

    public PlayerThread(Socket connection, int playerNumber) {
        this.connection = connection;
        this.playerNumber = playerNumber;
        connected = true;
        this.game = null;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        InputStream in = null;
        BufferedReader br = null;

        try {
            in = connection.getInputStream();
            br = new BufferedReader(new InputStreamReader(in));
            out = new DataOutputStream(connection.getOutputStream());
        } catch (IOException e) {
            System.out.println("Player " + playerNumber + " disconnected....");
            connected = false;
            return;
        }

        String line;
        while (true) {
            try {
                line = br.readLine();

                try {
                    JSONObject json = new JSONObject(line);
                    game.move(json.getInt("y"), json.getInt("x"), playerNumber);
                } catch (JSONException e) {
                    System.out.println("Failed parsing input from client...");
                }
            } catch (IOException e) {
                System.out.println("Player " + playerNumber + " disconnected....");
                connected = false;
                return;
            }
        }
    }

    public void sendMessage(JSONObject message) {
        try {
            out.writeBytes(message.toString());
            out.writeByte('\n');
        } catch (IOException e) {
            System.out.println("Error sending data to player " + playerNumber + "....");
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeBytes(message);
            out.writeByte('\n');
        } catch (IOException e) {
            System.out.println("Error sending data to player " + playerNumber + "....");
        }
    }
}
