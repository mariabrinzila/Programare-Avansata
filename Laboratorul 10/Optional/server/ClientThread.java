import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

class ClientThread extends Thread {
    private Socket socket;
    private SocialNetwork current;
    private Person currentUser = new Person();
    private int nr = 1;

    public ClientThread(Socket socket, SocialNetwork current) {
        this.socket = socket;
        this.current = current;
    }

    public void run() {
        try {
            socket.setSoTimeout(120000); //120 seconds = 2 minutes
            boolean over = false;
            String request, raspuns;
            int i, id;

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
                if (request.contains("register")) {
                    //add the new user in the social network
                    id = nr;
                    nr++;

                    String[] separated = request.split("register ");
                    String name = separated[1];

                    current.addUser(name, id);
                    Person user = new Person();
                    user.setId(id);
                    user.setName(name);
                    currentUser = user;

                    raspuns = "User " + currentUser.getName() + " was added to social network and is now logged in.";
                    out.println(raspuns);
                    out.flush();
                }
                else
                if (request.contains("login")) {
                    String[] separated = request.split("login ");
                    String name = separated[1];

                    ArrayList<Person> allUsers = current.getUsers();
                    int lg = allUsers.size();
                    for (i = 0; i < lg; i++) {
                        if (allUsers.get(i).getName().equals(name)) {
                            currentUser = allUsers.get(i);
                            break;
                        }
                    }
                    raspuns = "User " + currentUser.getName() + " is now logged in.";
                    out.println(raspuns);
                    out.flush();
                }
                else
                if (request.contains("send")) {
                    String[] separated = request.split("send ");
                    String message = separated[1];

                    int lg;
                    ArrayList<Person> friends = currentUser.getFriends();
                    lg = friends.size();

                    for (i = 0; i < lg; i++) {
                        friends.get(i).setReceivedMessage(message);
                    }

                    raspuns = "Message was sent.";
                    out.println(raspuns);
                    out.flush();
                }
                else
                if (request.contains("read")) {
                    String message = currentUser.getReceivedMessage();

                    raspuns = "You received the message " + message;
                    out.println(raspuns);
                    out.flush();
                }
                else
                if (request.contains("friend")) {
                    String[] separated = request.split("friend ");
                    String friends = separated[1];

                    if (friends.contains(", ")) {
                        //friend name1, name2, ..., namek
                        String[] split = friends.split(", ");
                        int L = split.length;

                        for (i = 1; i < L; i++) {
                            ArrayList<Person> allUsers = current.getUsers();
                            int lg = allUsers.size();
                            for (i = 0; i < lg; i++) {
                                if (allUsers.get(i).getName().equals(split[i])) {
                                    currentUser.addFriend(allUsers.get(i));
                                    break;
                                }
                            }
                        }

                        raspuns = (L - 1) + " friends have been added.";
                        out.println(raspuns);
                        out.flush();
                    }
                    else {
                        //friend name1

                        ArrayList<Person> allUsers = current.getUsers();
                        int lg = allUsers.size();
                        for (i = 0; i < lg; i++) {
                            if (allUsers.get(i).getName().equals(friends)) {
                                currentUser.addFriend(allUsers.get(i));
                                break;
                            }
                        }

                        raspuns = "One friend has been added.";
                        out.println(raspuns);
                        out.flush();
                    }
                }
                else {
                    //logout
                    raspuns = "Bye bye " + currentUser.getName();
                    out.println(raspuns);
                    out.flush();
                }
            }
        } catch (InterruptedIOException e) {
            try {
                System.out.println("User took more than " + socket.getSoTimeout() + " seconds.");
            } catch (SocketException socketException) {
                socketException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}