public class Main {
    public static void main(String[] args) {
        Game game = new Game("My Game");
        Board B = new Board(5);
        Player P1 = new Player("P1");
        Player P2 = new Player("P2");
        Player P3 = new Player("P3");

        P1.setCurrentGame(game);
        P2.setCurrentGame(game);
        P3.setCurrentGame(game);

        game.setGameBoard(B);
        game.addPlayer(P1);
        game.addPlayer(P2);
        game.addPlayer(P3);

        game.run();
    }
}