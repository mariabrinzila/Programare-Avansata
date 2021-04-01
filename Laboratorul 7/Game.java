import java.util.*;

public class Game extends Thread {
    String name;
    private List<Player> players = new ArrayList<>();
    Board gameBoard;

    public Game(String name) {
        this.name = name;
    }

    public void addPlayer(Player P) {
        players.add(P);
    }

    public void run() {
        for (Player P : players)
            new Thread(P).start();
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Board getGameBoard() {
        return gameBoard;
    }


}
