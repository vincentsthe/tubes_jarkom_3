import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerThread extends Thread {

    private Socket connection;

    private String username;

    private boolean connected;

    private Room room;

    private Game game;

    private DataOutputStream out;

    public PlayerThread(Socket connection) {
        this.connection = connection;
        connected = true;
        this.game = null;
    }

    public String getUsername() {
        if (username == null) {
            return "";
        } else {
            return username;
        }
    }

    public Room getRoom() {
        return room;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRoom(Room room) {
        this.room = room;
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
            System.out.println("Player " + username + " disconnected....");
            connected = false;
            return;
        }

        String line;
        while (true) {
            try {
                line = null;
                while (line == null) {
                    line = br.readLine();
                }

                try {
                    JSONObject json = new JSONObject(line);
                    processRequest(json);
                } catch (JSONException e) {
                    System.out.println("Failed parsing input from client...");
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Player " + username + " disconnected....");
                connected = false;
                return;
            }
        }
    }

    private void processRequest(JSONObject request) {

        try {
            String messageType = request.getString("message_type");
            String message = "";
            if (request.has("message")) {
                message = request.getString("message");
            }
            System.out.println(request.toString());

            if (messageType.equals("register")) {
                setUsername(message);
            } else if (messageType.equals("list_room")) {
                List<String> roomListName = Room.roomList.stream().map(m -> m.getName()).collect(Collectors.toList());
                String roomListJson = new Gson().toJson(roomListName);

                JSONObject json = new JSONObject();
                json.put("message_type", "list_room");
                json.put("message", roomListJson);
                sendMessage(json);
            } else if (messageType.equals("create_room")) {
                Room room = new Room(message);
                room.registerPlayer(this);
            } else if (messageType.equals("start_room")) {
                getRoom().startGame();
            } else if (messageType.equals("join_room")) {
                Room room = Room.getRoomByRoomName(message);
                setRoom(room);
                getRoom().registerPlayer(this);
            } else if (messageType.equals("list_player_room")) {
                setRoom(Room.getRoomByRoomName(message));
                List<String> userList = getRoom().getPlayers().stream().map(m -> m.getUsername()).collect(Collectors.toList());
                String userListJson = new Gson().toJson(userList);

                JSONObject json = new JSONObject();
                json.put("message_type", "list_room");
                json.put("message", userListJson);
                System.out.println(json.toString());
                sendMessage(json);
            } else if (messageType.equals("move")) {
                JSONObject position = new JSONObject(message);
                getRoom().getGame().move(position.getInt("y"), position.getInt("x"), this);
            } else if (messageType.equals("request_board")) {
                Room room = Room.getRoomByRoomName(message);
                Game game = room.getGame();
                Gson gson = new Gson();

                if (!game.haveWinner()) {
                    String boardJson = gson.toJson(game.getBoard());

                    JSONObject json = new JSONObject();
                    json.put("message_type", "board");
                    json.put("message", boardJson);

                    sendMessage(json.toString());
                } else {
                    JSONObject json = new JSONObject();
                    json.put("message_type", "winner");
                    json.put("message", game.getWinner());

                    sendMessage(json.toString());
                }
            }
        } catch (JSONException ex) {
            System.out.println("Invalid request");
        }
    }

    public void notifyGameStart() {
        try {
            JSONObject json = new JSONObject();
            json.put("message_type", "start_game");
            out.writeBytes(json.toString());
            out.writeByte('\n');
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(JSONObject message) {
        try {
            out.writeBytes(message.toString());
            out.writeByte('\n');
        } catch (IOException e) {
            System.out.println("Error sending data to player " + username + "....");
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeBytes(message);
            out.writeByte('\n');
        } catch (IOException e) {
            System.out.println("Error sending data to player " + username + "....");
        }
    }
}
