import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8100;

    public Server() throws IOException {
        ServerSocket serverSocket = null;
        SocialNetwork current = new SocialNetwork();

        try {
            serverSocket = new ServerSocket(PORT);
            boolean over = false;

            while (!over) {
                System.out.println ("Waiting for a client");
                Socket socket = serverSocket.accept();

                new ClientThread(socket, current).start();
            }
        } catch (IOException e) {
            System.err.println ("Error: " + e);
        } finally {
            serverSocket.close();
        }
    }
}
