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

        for (int row = 0; row < gameBoard.length; row++) {
            if (gameBoard[row][0].equals(gameBoard[row][1]) && gameBoard[row][1].equals(gameBoard[row][2])) {
                if (gameBoard[row][0].contains(gameLetter)) {
                    return +10;
                } else if (gameBoard[row][0].contains(opponent)) {
                    return -10;
                }
            }
        }
        for (int col = 0; col < gameBoard[0].length; col++) {
            if (gameBoard[0][col].equals(gameBoard[1][col]) && gameBoard[1][col].equals(gameBoard[2][col])) {
                if (gameBoard[0][col].contains(gameLetter)) {
                    return +10;
                } else if (gameBoard[0][col].contains(opponent)) {
                    return -10;
                }
            }
        }
        if (gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][2])) {
            if (gameBoard[0][0].contains(gameLetter)) {
                return +10;
            } else if (gameBoard[0][0].contains(opponent)) {
                return -10;
            }
        }
        if (gameBoard[0][2].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][0])) {
            if (gameBoard[0][2].contains(gameLetter)) {
                return +10;
            } else if (gameBoard[0][2].contains(opponent)) {
                return -10;
            }
        }
        return 0;
    }

    public int minimax(Board board, int depth, boolean isMax) {

        String[][] gameBoard = board.currentBoard();

        int score = evaluate(board);

        if (score == +10) {
            return score;
        }
        if (score == -10) {
            return score;
        }
        if (!isMovesLeft((board))) {
            return 0;
        }

        if (isMax) {

            int bestMax = Integer.MIN_VALUE;

            for (int row = 0; row < gameBoard.length; row++) {
                for (int col = 0; col < gameBoard[0].length; col++) {
                    if (gameBoard[row][col].contains(" ")) {
                        gameBoard[row][col] = gameLetter;
                        bestMax = Math.max(bestMax, minimax(board, depth + 1, false));
                        gameBoard[row][col] = " ";
                    }
                }
            }
            return bestMax;
        } else {
            int bestMin = Integer.MAX_VALUE;

            for (int row = 0; row < gameBoard.length; row++) {
                for (int col = 0; col < gameBoard[0].length; col++) {
                    if (gameBoard[row][col].contains(" ")) {
                        gameBoard[row][col] = opponent;
                        bestMin = Math.min(bestMin, minimax(board, depth + 1, true));
                        gameBoard[row][col] = " ";
                    }
                }
            }
            return bestMin;
        }
    }

    public void bestMove(Board board) {

        String[][] gameBoard = board.currentBoard();

        int bestVal = Integer.MIN_VALUE;

        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col <gameBoard[0].length; col++) {
                if (gameBoard[row][col].contains(" ")) {
                    gameBoard[row][col] = gameLetter;
                    int moveVal = minimax(board, 0, false);
                    gameBoard[row][col] = " ";
                    if (moveVal > bestVal) {
                        x = row;
                        y = col;
                        bestVal = moveVal;
                    }
                }
            }
        }
        board.updateBoard(x , y, gameLetter);
    }
}
