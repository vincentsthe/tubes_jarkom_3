import org.json.JSONObject;

import java.io.*;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);
        try
        {
            System.out.println("Connecting to " + serverName + " on port " + port);

            Socket client = new Socket(serverName, port);
            System.out.println("Just connected to " + client.getRemoteSocketAddress());

            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            JSONObject json = new JSONObject();
            try {
                json.put("message_type", "register");
                json.put("message", "vincent");
            } catch (Exception e) {
                e.printStackTrace();
            }
            out.writeBytes(json.toString());

            InputStream inFromServer = client.getInputStream();

//            client.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
