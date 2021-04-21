public class Board {
    private final String[][] board;
    int x;
    int o;

    public Board() {
        this.board = new String[3][3];
        int x = 0;
        int y = 0;
    }

    public void setBoard(String[] input) {
        int pos = 0;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                {
                    board[row][col] = input[pos];
                    pos++;
                }
            }
        }

        for (String string : input) {
            if (string.contains("X")) {
                x++;
            } else if (string.contains("O")) {
                o++;
            }
        }
    }

    public void printBoard() {

        System.out.println("---------");
        for (String[] strings : board) {
            System.out.print("| ");
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    public int getX() {
        return x;
    }

    public int getO() {
        return o;
    }

    public void updateBoard(int row, int col) {
        if (x > o) {
            board[row - 1][col - 1] = "O";
        } else if (o > x || o == x) {
            board[row - 1][col - 1] = "X";
        }
    }

    public String[][] currentBoard() {
        return board;
    }
}