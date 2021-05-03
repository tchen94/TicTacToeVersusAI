import java.util.Random;

public class MediumAI {

    private final Random random;
    private String gameLetter;
    private int x;
    private int y;

    public MediumAI() {
        this.random = new Random();
        this.gameLetter = "";
    }

    public void setGameLetter(String gameLetter) {
        this.gameLetter = gameLetter;
    }

    public String getGameLetter() {
        return gameLetter;
    }

    public void move(Board board, String opponentLetter) {

        String[][] gameBoard = board.currentBoard();

        while (true) {

            if (blockSearch(board, opponentLetter)) {
                System.out.println("Making move level \"medium\"");
                board.updateBoard(x + 1, y + 1, gameLetter);
                break;
            }
            if (winSearch(board, gameLetter)) {
                System.out.println("Making move level \"medium\"");
                board.updateBoard(x + 1, y + 1, gameLetter);
                break;
            }
            if (!blockSearch(board, opponentLetter) && !winSearch(board, gameLetter)){

                while (true) {

                    x = random.nextInt(3) + 1;
                    y = random.nextInt(3) + 1;

                    if (gameBoard[x - 1][y - 1].contains("X") || gameBoard[x - 1][y - 1].contains("O")) {
                        continue;
                    }
                    break;
                }
                System.out.println("Making move level \"medium\"");
                board.updateBoard(x, y, gameLetter);
                break;
            }
            blockSearch(board, opponentLetter);
            winSearch(board, gameLetter);
        }
    }


    public boolean blockSearch(Board board, String opponentLetter) {

        String[][] gameBoard = board.currentBoard();
        // Checking for row wins
        for (int row = 0; row < gameBoard.length; row++) {
            if (gameBoard[row][0].contains(opponentLetter) &&
                    gameBoard[row][0].equals(gameBoard[row][1]) && gameBoard[row][2].contains(" ")) {
                x = row;
                y = 2;
                return true;
            } else if (gameBoard[row][0].contains(opponentLetter) &&
                    gameBoard[row][0].equals(gameBoard[row][2]) && gameBoard[row][1].contains(" ")) {
                x = row;
                y = 1;
                return true;
            } else if (gameBoard[row][1].contains(opponentLetter) &&
                    gameBoard[row][1].equals(gameBoard[row][2]) && gameBoard[row][0].contains(" ")) {
                x = row;
                y = 0;
                return true;
            }
        }
        // Checking for column blocks
        for (int col = 0; col < gameBoard[0].length; col++) {
            if (gameBoard[0][col].contains(opponentLetter) &&
                    gameBoard[0][col].equals(gameBoard[1][col]) && gameBoard[2][col].contains(" ")) {
                x = 2;
                y = col;
                return true;
            } else if (gameBoard[0][col].contains(opponentLetter) &&
                    gameBoard[0][col].equals(gameBoard[2][col]) && gameBoard[1][col].contains(" ")) {
                x = 1;
                y = col;
                return true;
            } else if (gameBoard[1][col].contains(opponentLetter) &&
                    gameBoard[1][col].equals(gameBoard[2][col]) && gameBoard[0][col].contains(" ")) {
                x = 0;
                y = col;
                return true;
            }
        }
        //Checking main diagonal
        if (gameBoard[0][0].contains(opponentLetter) &&
                gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[2][2].contains(" ")) {
            x = 2;
            y = 2;
            return true;
        } else if (gameBoard[0][0].contains(opponentLetter) &&
                gameBoard[0][0].equals(gameBoard[2][2]) && gameBoard[1][1].contains(" ")) {
            x = 1;
            y = 1;
            return true;
        } else if (gameBoard[1][1].contains(opponentLetter) &&
                gameBoard[1][1].equals(gameBoard[2][2]) && gameBoard[0][0].contains(" ")) {
            x = 0;
            y = 0;
            return true;
        }
        // Checking secondary diagonal
        if (gameBoard[0][2].contains(opponentLetter) &&
                gameBoard[0][2].equals(gameBoard[1][1]) && gameBoard[2][0].contains(" ")) {
            x = 2;
            y = 0;
            return true;
        } else if (gameBoard[0][2].contains(opponentLetter) &&
                gameBoard[0][2].equals(gameBoard[2][0]) && gameBoard[1][1].contains(" ")) {
            x = 1;
            y = 1;
            return true;
        } else if (gameBoard[2][0].contains(opponentLetter) &&
                gameBoard[2][0].equals(gameBoard[1][1]) && gameBoard[0][2].contains(" ")) {
            x = 0;
            y = 2;
            return true;
        }
        return false;
    }

    public boolean winSearch(Board board, String opponentLetter) {

        String[][] gameBoard = board.currentBoard();
        // Checking for row wins
        for (int row = 0; row < gameBoard.length; row++) {
            if (gameBoard[row][0].contains(gameLetter) &&
                    gameBoard[row][0].equals(gameBoard[row][1]) && gameBoard[row][2].contains(" ")) {
                x = row;
                y = 2;
                return true;
            } else if (gameBoard[row][0].contains(gameLetter) &&
                    gameBoard[row][0].equals(gameBoard[row][2]) && gameBoard[row][1].contains(" ")) {
                x = row;
                y = 1;
                return true;
            } else if (gameBoard[row][1].contains(gameLetter) &&
                    gameBoard[row][1].equals(gameBoard[row][2]) && gameBoard[row][0].contains(" ")) {
                x = row;
                y = 0;
                return true;
            }
        }
        // Checking for column blocks
        for (int col = 0; col < gameBoard[0].length; col++) {
            if (gameBoard[0][col].contains(gameLetter) &&
                    gameBoard[0][col].equals(gameBoard[1][col]) && gameBoard[2][col].contains(" ")) {
                x = 2;
                y = col;
                return true;
            } else if (gameBoard[0][col].contains(gameLetter) &&
                    gameBoard[0][col].equals(gameBoard[2][col]) && gameBoard[1][col].contains(" ")) {
                x = 1;
                y = col;
                return true;
            } else if (gameBoard[1][col].contains(gameLetter) &&
                    gameBoard[1][col].equals(gameBoard[2][col]) && gameBoard[0][col].contains(" ")) {
                x = 0;
                y = col;
                return true;
            }
        }
        //Checking main diagonal
        if (gameBoard[0][0].contains(gameLetter) &&
                gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[2][2].contains(" ")) {
            x = 2;
            y = 2;
            return true;
        } else if (gameBoard[0][0].contains(gameLetter) &&
                gameBoard[0][0].equals(gameBoard[2][2]) && gameBoard[1][1].contains(" ")) {
            x = 1;
            y = 1;
            return true;
        } else if (gameBoard[1][1].contains(gameLetter) &&
                gameBoard[1][1].equals(gameBoard[2][2]) && gameBoard[0][0].contains(" ")) {
            x = 0;
            y = 0;
            return true;
        }
        // Checking secondary diagonal
        if (gameBoard[0][2].contains(gameLetter) &&
                gameBoard[0][2].equals(gameBoard[1][1]) && gameBoard[2][0].contains(" ")) {
            x = 2;
            y = 0;
            return true;
        } else if (gameBoard[0][2].contains(gameLetter) &&
                gameBoard[0][2].equals(gameBoard[2][0]) && gameBoard[1][1].contains(" ")) {
            x = 1;
            y = 1;
            return true;
        } else if (gameBoard[2][0].contains(gameLetter) &&
                gameBoard[2][0].equals(gameBoard[1][1]) && gameBoard[0][2].contains(" ")) {
            x = 0;
            y = 2;
            return true;
        }
        return false;
    }
}
