import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] argv) {
        int port = Integer.parseInt(argv[0]);

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);

            GameSetter gameSetter = new GameSetter(serverSocket);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String command = "";
            while (!command.equals("start")) {
                command = reader.readLine();
            }

            Game game = gameSetter.createGame();
            game.start();
        } catch (IOException e) {
            System.out.println("Error establishing socket");
        }
    }
}
