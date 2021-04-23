import java.util.Scanner;

public class Game {

    private final Scanner scanner;
    private boolean xWin;
    private boolean oWin;
    private boolean draw;
    private int inputRow;
    private int inputCol;
    private final AI cpu;

    public Game() {

        this.scanner = new Scanner(System.in);
        this.xWin = false;
        this.oWin = false;
        this.draw = false;
        this.cpu = new AI();
    }

    public void rowCheck(Board board) {
        String[][] gameBoard = board.currentBoard();

        // Checking for X win
        for (String[] letter : gameBoard) {
            if (letter[0].contains("X")) {
                if (letter[0].equals(letter[1]) && letter[1].equals(letter[2])) {
                    xWin = true;
                    break;
                }
            }
            // Checking for O win
            if (letter[0].contains("O")) {
                if (letter[0].equals(letter[1]) && letter[1].equals(letter[2])) {
                    oWin = true;
                    break;
                }
            }
        }
    }

    public void colCheck(Board board) {
        String[][] gameBoard = board.currentBoard();
        // Checking for X win
        for (int col = 0; col < gameBoard.length; col++) {
            if (gameBoard[0][col].contains("X")) {
                if (gameBoard[0][col].equals(gameBoard[1][col]) && gameBoard[1][col].equals(gameBoard[2][col])) {
                    xWin = true;
                    break;
                }
            }
            // Checking for O win
            if (gameBoard[0][col].contains("O")) {
                if (gameBoard[0][col].equals(gameBoard[1][col]) && gameBoard[1][col].equals(gameBoard[2][col])) {
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

    public void playerCoordinates(Board board) {

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

    public void gameState(Board board) {

        rowCheck(board);
        diagCheck(board);
        drawCheck(board);
        colCheck(board);
    }

    public void playerVersusCPU() {
        Board board = new Board();
        board.emptyBoard();

        while (true) {

            gameState(board);

            if (xWin || xWin && draw) {
                System.out.println("X wins");
                reset();
                break;
            }
            if (oWin || oWin && draw) {
                System.out.println("O wins");
                reset();
                break;
            }
            if (draw) {
                System.out.println("Draw");
                reset();
                break;
            }

            if (board.getX() < board.getO() || board.getX() == board.getO()) {
                playerCoordinates(board);
                board.updateBoard(inputRow, inputCol);
            } else {
                cpu.easyCPU(board);
            }
            board.printBoard();
        }
    }

    private void cpuVersusPlayer() {
        Board board = new Board();
        board.emptyBoard();

        while (true) {

            gameState(board);

            if (xWin || xWin && draw) {
                System.out.println("X wins");
                reset();
                break;
            }
            if (oWin || oWin && draw) {
                System.out.println("O wins");
                reset();
                break;
            }
            if (draw) {
                System.out.println("Draw");
                reset();
                break;
            }

            if (board.getX() < board.getO() || board.getX() == board.getO()) {
                cpu.easyCPU(board);
            } else {
                playerCoordinates(board);
                board.updateBoard(inputRow, inputCol);
            }
            board.printBoard();
        }
    }


    public void playerVersusPlayer() {
        Board board = new Board();
        board.emptyBoard();

        while (true) {

            gameState(board);

            if (xWin || xWin && draw) {
                System.out.println("X wins");
                reset();
                break;
            }
            if (oWin || oWin && draw) {
                System.out.println("O wins");
                reset();
                break;
            }
            if (draw) {
                System.out.println("Draw");
                reset();
                break;
            }

            playerCoordinates(board);
            board.updateBoard(inputRow, inputCol);
            board.printBoard();
        }
    }

    public void cpuVersusCPU() {
        Board board = new Board();
        AI cpu = new AI();
        board.emptyBoard();

        while (true) {

            gameState(board);

            if (xWin || xWin && draw) {
                System.out.println("X wins");
                reset();
                break;
            }
            if (oWin || oWin && draw) {
                System.out.println("O wins");
                reset();
                break;
            }
            if (draw) {
                System.out.println("Draw");
                reset();
                break;
            }

            cpu.easyCPU(board);
            board.printBoard();
        }
    }

    public void playerVersusMediumCPU() {
    }

    public void mediumCPUVersusPlayer() {
    }

    public void mediumCPUVersusMediumCPU() {
    }

    public void reset() {
        oWin = false;
        xWin = false;
        draw = false;
    }

    public void gameMenu() {

        while (true) {
            System.out.print("Input command: ");

            String input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            }

            switch (input) {
                case "start easy easy":
                    cpuVersusCPU();
                    break;
                case "start medium medium":
                    mediumCPUVersusMediumCPU();
                case "start easy user":
                    cpuVersusPlayer();
                    break;
                case "start medium user":
                    mediumCPUVersusPlayer();
                case "start user easy":
                    playerVersusCPU();
                    break;
                case "start user medium":
                    playerVersusMediumCPU();
                    break;
                case "start user user":
                    playerVersusPlayer();
                    break;
                default:
                    System.out.println("Bad parameters!");
                    break;
            }
        }
    }

    public void start() {
        gameMenu();
    }
}