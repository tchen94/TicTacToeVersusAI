public class HardAI {

    private String gameLetter;
    private String opponent;
    private int x;
    private int y;

    public HardAI() {
        this.gameLetter = "";
        this.opponent = "";
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setGameLetter(String gameLetter) {
        this.gameLetter = gameLetter;
    }

    public String getGameLetter() {
        return gameLetter;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public String getOpponent() {
        return opponent;
    }

    public void move(Board board) {

            bestMove(board);
            System.out.println("Making move level \"hard\"");
    }

    public boolean isMovesLeft(Board board) {
        String[][] gameBoard = board.currentBoard();

        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[0].length; col++) {
                if (gameBoard[row][col].contains(" ")) {
                    return true;
                }
            }
        }
        return false;
    }

    public int evaluate(Board board) {
        String[][] gameBoard = board.currentBoard();

        for (String[] position : gameBoard) {
            if (position[0].equals(position[1]) && position[1].equals(position[2])) {
                if (position[0].contains("X")) {
                    return +1;
                } else if (position[0].contains("O")) {
                    return -1;
                }
            }
        }
        for (int col = 0; col < gameBoard[0].length; col++) {
            if (gameBoard[0][col].equals(gameBoard[1][col]) && gameBoard[1][col].equals(gameBoard[2][col])) {
                if (gameBoard[0][col].contains("X")) {
                    return +1;
                } else if (gameBoard[0][col].contains("O")) {
                    return -1;
                }
            }
        }
        if (gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][2])) {
            if (gameBoard[0][0].contains("X")) {
                return +1;
            } else if (gameBoard[0][0].contains("O")) {
                return -1;
            }
        }
        if (gameBoard[0][2].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][0])) {
            if (gameBoard[0][2].contains("X")) {
                return +1;
            } else if (gameBoard[0][2].contains("O")) {
                return -1;
            }
        }
        return 0;
    }

    public int minimax(Board board, int depth, boolean isMax) {

        String[][] gameBoard = board.currentBoard();

        int score = evaluate(board);

        if (score == 10) {
            return score;
        }

        if (score == -10) {
            return score;
        }

        if (!isMovesLeft(board)) {
            return 0;
        }

        if (isMax) {
            int best = -1000;

            for (int row = 0; row < gameBoard.length; row++) {
                for (int col = 0; col < gameBoard[0].length; col++) {
                    if (gameBoard[row][col].contains(" ")) {
                        gameBoard[row][col] = gameLetter;
                        best = Math.max(best, minimax(board, depth + 1, !isMax));
                        gameBoard[row][col] = " ";
                    }
                }
            }
            return best;
        } else {
            int best = 1000;

            for (int row = 0; row < gameBoard.length; row++) {
                for (int col = 0; col < gameBoard[0].length; col++) {
                    if (gameBoard[row][col].contains(" ")) {
                        gameBoard[row][col] = opponent;
                        best = Math.min(best, minimax(board, depth + 1, !isMax));
                        gameBoard[row][col] = " ";
                    }
                }
            }
            return best;
        }
    }

    public void findBestMove(Board board) {

        String[][] gameBoard = board.currentBoard();

        int bestVal = -1000;
        HardAI cpu = new HardAI();
        cpu.setX(-1);
        cpu.setY(-1);

        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col <gameBoard[0].length; col++) {
                if (gameBoard[row][col].contains(" ")) {

                    gameBoard[row][col] = gameLetter;
                    int moveVal = minimax(board, 3, false);
                    gameBoard[row][col] = " ";

                    if (moveVal > bestVal) {
                        x = row;
                        y = col;
                        bestVal = moveVal;
                    }
                }
            }
        }
    }
}
