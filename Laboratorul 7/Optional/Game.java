import java.util.*;

public class Game extends Thread {
    private String name;
    private List<Player> players = new ArrayList<>();
    private Board gameBoard;
    private int maxScore;
    private String winnerName;
    private boolean gameOver;
    private boolean turnDone;

    public Game(String name) {
        this.name = name;
        this.maxScore = 0;
        this.winnerName = null;
        this.gameOver = false;
    }

    public void addPlayer(Player P) {
        players.add(P);
    }

    public void run() {
        for (Player P : players) {
            new Thread(P).start();
        }
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

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public boolean isTurnDone() {
        return turnDone;
    }

    public void setTurnDone(boolean turnDone) {
        this.turnDone = turnDone;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;

        /**
         * if the value of the variable is true, then it means the game is over
         * and then we should announce (print) the winner and his score
         */
        if (gameOver == true) {
            System.out.println("The game is over and the winner is player " + winnerName + " and his score is " + maxScore);
        }
    }
}
