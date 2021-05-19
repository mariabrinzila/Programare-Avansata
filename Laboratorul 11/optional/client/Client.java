import org.omg.CORBA.TIMEOUT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {
    public static void main (String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        int PORT = 8100;

        try (Socket socket = new Socket(serverAddress, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())))
        {
            socket.setSoTimeout(10000);
            TIMEOUT x;
            boolean over = false;
            String request, response;

            while (!over) {
                //read client's request from console
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                request = reader.readLine();

                out.println(request);
                response = in.readLine();
                System.out.println(response);

                if (request.equals("logout") || request.equals("stop")) {
                    over = true;
                    socket.close();
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening" + e);
        } catch (SocketException e) {
            System.out.println("User took more than 2 minutes to make a request so the connection closed.");
        }
    }
}
