import java.util.Scanner;

public class Game {

    private boolean xWin;
    private boolean oWin;
    private boolean draw;
    private int inputRow;
    private int inputCol;
    private final Scanner scanner;

    public Game() {

        this.scanner = new Scanner(System.in);
        this.xWin = false;
        this.oWin = false;
        this.draw = false;
    }

    public void rowCheck(Board board) {
        String[][] gameBoard = board.currentBoard();

        // Checking for X win
        for (String[] strings : gameBoard) {
            if (strings[0].contains("X")) {
                if (strings[0].equals(strings[1]) && strings[1].equals(strings[2])) {
                    xWin = true;
                    break;
                }
            }
            // Checking for O win
            if (strings[0].contains("O")) {
                if (strings[0].equals(strings[1]) && strings[1].equals(strings[2])) {
                    oWin = true;
                    break;
                }
            }
        }
    }

    public void diagCheck(Board board) {
        String[][] gameBoard = board.currentBoard();

        // Checking for X win in each diagonal
        if (gameBoard[0][0].contains("X")) {
            if (gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][2])) {
                xWin = true;
            }
        }
        if (gameBoard[0][2].contains("X")) {
            if (gameBoard[0][2].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][0])) {
                xWin = true;
            }
        }
        // Checking for O win in each diagonal
        if (gameBoard[0][0].contains("O")) {
            if (gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][2])) {
                oWin = true;
            }
        }
        if (gameBoard[0][2].contains("O")) {
            if (gameBoard[0][2].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][0])) {
                oWin = true;
            }
        }
    }

    public void drawCheck(Board board) {
        draw = board.getX() + board.getO() == 9;
    }

    public void result() {

        if (xWin) {
            System.out.println("X wins");
        } else if (oWin) {
            System.out.println("O wins");
        } else if (draw) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }

    }

    public void getCoordinates(Board board) {

        String[][] gameBoard = board.currentBoard();

        while (true) {
            try {
                System.out.print("Enter the coordinates: ");
                String playerMove = scanner.nextLine();
                String[] parts = playerMove.split(" ");
                inputRow = Integer.parseInt(parts[0]);
                inputCol = Integer.parseInt(parts[1]);

                if (inputRow < 0 || inputCol < 0 || inputRow > 3 || inputCol > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (gameBoard[inputRow - 1][inputCol - 1].contains("X") ||
                        gameBoard[inputRow - 1][inputCol - 1].contains("O")){
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }
            break;
        }
    }


    public void start() {

        Board board = new Board();

        System.out.print("Enter the cells: ");
        String[] input = scanner.nextLine().split("");
        board.setBoard(input);
        board.printBoard();

        getCoordinates(board);
        board.updateBoard(inputRow, inputCol);
        board.printBoard();

        rowCheck(board);
        diagCheck(board);
        drawCheck(board);
        result();
    }
}