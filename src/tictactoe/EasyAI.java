import java.util.Random;

public class EasyAI {

    private final Random random;
    private String gameLetter;

    public EasyAI() {
        this.random = new Random();
        this.gameLetter = "";
    }

    public void setGameLetter(String gameLetter) {
        this.gameLetter = gameLetter;
    }

    public String getGameLetter() {
        return gameLetter;
    }

    public void move(Board board) {

        int row;
        int col;

        String[][] gameBoard = board.currentBoard();

        while (true) {
            try {
                row = random.nextInt(3) + 1;
                col = random.nextInt(3) + 1;

                if (gameBoard[row - 1][col - 1].contains("X") || gameBoard[row - 1][col - 1].contains("O")){
                    continue;
                }
            } catch (NumberFormatException e) {
                continue;
            }
            System.out.println("Making move level \"easy\"");
            break;
        }
        board.updateBoard(row - 1, col - 1, gameLetter);
    }
}
