import java.util.Random;

public class AI {

    Random random;

    public AI() {
        this.random = new Random();
    }

    public void easyCPU(Board board) {

        String[][] gameBoard = board.currentBoard();
        int row;
        int col;

        while (true) {
            try {
                row = random.nextInt(3) + 1;
                col = random.nextInt(3) + 1;

                if (row < 0 || col < 0 || row > 3 || col > 3) {
                    continue;
                }
                if (gameBoard[row - 1][col - 1].contains("X") ||
                        gameBoard[row - 1][col - 1].contains("O")){
                    continue;
                }
            } catch (NumberFormatException e) {
                continue;
            }

            System.out.println("Making move level \"easy\"");
            break;
        }

        board.updateBoard(row, col);
    }

    public void mediumCPU(Board board) {

    }
}
