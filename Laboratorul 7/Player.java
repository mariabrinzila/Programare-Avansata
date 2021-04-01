import java.util.*;

public class Player implements Runnable {
    private String name;
    private boolean isRunning;
    private Game currentGame;
    private List<Token> sequence = new ArrayList<>();
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    private boolean isGameDone() {
        List<Token> tokensLeft = currentGame.getGameBoard().getTokens();

        if (tokensLeft.isEmpty()) {
            int i;

            for (i = 0; i < sequence.size(); i++)
                score += sequence.get(i).getValue();

            return true;
        }

        if (currentGame.getGameBoard().extractTokens() == null)
            return true;

        sequence.add(currentGame.getGameBoard().extractTokens());
        return false;
    }

    @Override
    public void run() {
        isRunning = true;

        while (isRunning) {
            if (isGameDone()) {
                isRunning = false;

                System.out.println("Game is done and the the player's " + this.name + " score is: " + this.score);
            }
        }
    }
}
