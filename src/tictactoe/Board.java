public class Board {
    private final String[][] board;
    private int x;
    private int o;

    public Board() {
        this.board = new String[3][3];
        this.x = 0;
        this.o = 0;
    }

    public void emptyBoard() {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                {
                    board[row][col] = " ";
                }
            }
        }
        printBoard();
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
            o++;
        } else if (o > x || o == x) {
            board[row - 1][col - 1] = "X";
            x++;
        }
    }

    public String[][] currentBoard() {
        return board;
    }
}