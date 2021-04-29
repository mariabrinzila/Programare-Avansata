import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            boolean over = false;
            String request, raspuns;

            while (!over) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                request = in.readLine();
                PrintWriter out = new PrintWriter(socket.getOutputStream());

                if (request.equals("stop")) {
                    raspuns = "Server stopped";
                    out.println(raspuns);
                    out.flush();
                    over = true;
                    socket.close();
                    System.exit(1);
                }
                else
                    raspuns = "Server received the request: " + request;

                out.println(raspuns);
                out.flush();
            }
        } catch (IOException e) {
            System.err.println("Communication error: " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
