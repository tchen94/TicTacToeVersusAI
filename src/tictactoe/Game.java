import java.util.Scanner;

public class Game {

    private final Scanner scanner;
    private boolean xWin;
    private boolean oWin;
    private boolean draw;
    private String currentTurn;

    public Game() {

        this.scanner = new Scanner(System.in);
        this.xWin = false;
        this.oWin = false;
        this.draw = false;
        this.currentTurn = "X";
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

    public void gameState(Board board) {
        drawCheck(board);
        rowCheck(board);
        colCheck(board);
        diagCheck(board);
    }

    public void playerVersusCPUEasy(Player player, EasyAI cpu, Board board) {

        while (true) {

            gameState(board);

            if (xWin || xWin && draw) {
                System.out.println("X wins");
                System.out.println();
                reset(board);
                break;
            }
            if (oWin || oWin && draw) {
                System.out.println("O wins");
                System.out.println();
                reset(board);
                break;
            }
            if (draw) {
                System.out.println("Draw");
                System.out.println();
                reset(board);
                break;
            }

            if (currentTurn.equals("X")) {
                player.move(board);
                currentTurn = "O";
            } else {
                cpu.move(board);
                currentTurn = "X";
            }
            board.printBoard();
        }
    }

    public void playerVersusMediumCPU(Player player, MediumAI cpu, Board board) {

        while (true) {

            gameState(board);

            if (xWin || xWin && draw) {
                System.out.println("X wins");
                System.out.println();
                reset(board);
                break;
            }
            if (oWin || oWin && draw) {
                System.out.println("O wins");
                System.out.println();
                reset(board);
                break;
            }
            if (draw) {
                System.out.println("Draw");
                System.out.println();
                reset(board);
                break;
            }

            if (currentTurn.equals("X")) {
                player.move(board);
                currentTurn = "O";
            } else {
                cpu.move(board, player.getGameLetter());
                currentTurn = "X";
            }
            board.printBoard();
        }
    }

    public void playerVersusHardCPU(Player player, HardAI cpu, Board board) {

        while (true) {

            gameState(board);

            if (xWin || xWin && draw) {
                System.out.println("X wins");
                System.out.println();
                reset(board);
                break;
            }
            if (oWin || oWin && draw) {
                System.out.println("O wins");
                System.out.println();
                reset(board);
                break;
            }
            if (draw) {
                System.out.println("Draw");
                System.out.println();
                reset(board);
                break;
            }

            if (currentTurn.equals("X")) {
                player.move(board);
                currentTurn = "O";
            } else {
                cpu.move(board);
                currentTurn = "X";
            }
            board.printBoard();
        }
    }

    public void cpuEasyVersusCPUEasy(EasyAI cpuOne, EasyAI cpuTwo, Board board) {

        while (true) {

            gameState(board);

            if (xWin || xWin && draw) {
                System.out.println("X wins");
                System.out.println();
                reset(board);
                break;
            }
            if (oWin || oWin && draw) {
                System.out.println("O wins");
                System.out.println();
                reset(board);
                break;
            }
            if (draw) {
                System.out.println("Draw");
                System.out.println();
                reset(board);
                break;
            }

            if (currentTurn.equals("X")) {
                cpuOne.move(board);
                currentTurn = "O";
            } else {
                cpuTwo.move(board);
                currentTurn = "X";
            }
            board.printBoard();
        }
    }

    public void mediumCPUVersusMediumCPU(MediumAI cpuOne, MediumAI cpuTwo, Board board) {

        while (true) {

            gameState(board);

            if (xWin || xWin && draw) {
                System.out.println("X wins");
                System.out.println();
                reset(board);
                break;
            }
            if (oWin || oWin && draw) {
                System.out.println("O wins");
                System.out.println();
                reset(board);
                break;
            }
            if (draw) {
                System.out.println("Draw");
                System.out.println();
                reset(board);
                break;
            }

            if (currentTurn.equals("X")) {
                cpuOne.move(board, cpuTwo.getGameLetter());
                currentTurn = "O";
            } else {
                cpuTwo.move(board, cpuOne.getGameLetter());
                currentTurn = "X";
            }
            board.printBoard();
        }
    }

    public void hardCPUVersusHardCPU(HardAI cpuOne, HardAI cpuTwo, Board board) {

        while (true) {

            gameState(board);

            if (xWin || xWin && draw) {
                System.out.println("X wins");
                System.out.println();
                reset(board);
                break;
            }
            if (oWin || oWin && draw) {
                System.out.println("O wins");
                System.out.println();
                reset(board);
                break;
            }
            if (draw) {
                System.out.println("Draw");
                System.out.println();
                reset(board);
                break;
            }

            if (currentTurn.equals("X")) {
                cpuOne.move(board);
                currentTurn = "O";
            } else {
                cpuTwo.move(board);
                currentTurn = "X";
            }
            board.printBoard();
        }
    }

    public void hardCPUVersusPlayer(HardAI cpu, Player player, Board board) {

        while (true) {

            gameState(board);

            if (xWin || xWin && draw) {
                System.out.println("X wins");
                System.out.println();
                reset(board);
                break;
            }
            if (oWin || oWin && draw) {
                System.out.println("O wins");
                System.out.println();
                reset(board);
                break;
            }
            if (draw) {
                System.out.println("Draw");
                System.out.println();
                reset(board);
                break;
            }

            if (currentTurn.equals("X")) {
                cpu.move(board);
                currentTurn = "O";
            } else {
                player.move(board);
                currentTurn = "X";
            }
            board.printBoard();
        }
    }

    public void playerVersusPlayer(Player playerOne, Player playerTwo, Board board) {

        while (true) {

            gameState(board);

            if (xWin || xWin && draw) {
                System.out.println("X wins");
                System.out.println();
                reset(board);
                break;
            }
            if (oWin || oWin && draw) {
                System.out.println("O wins");
                System.out.println();
                reset(board);
                break;
            }
            if (draw) {
                System.out.println("Draw");
                System.out.println();
                reset(board);
                break;
            }

            if (currentTurn.equals("X")) {
                playerOne.move(board);
                currentTurn = "O";
            } else {
                playerTwo.move(board);
                currentTurn = "X";
            }
            board.printBoard();
        }
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


    public void reset(Board board) {
        oWin = false;
        xWin = false;
        draw = false;
        currentTurn = "X";
        board.setX(0);
        board.setO(0);
    }

    public void gameMenu() {

        Board board = new Board();
        EasyAI cpuOneEasy = new EasyAI();
        EasyAI cpuTwoEasy = new EasyAI();
        MediumAI cpuOneMedium = new MediumAI();
        MediumAI cpuTwoMedium = new MediumAI();
        HardAI cpuOneHard = new HardAI();
        HardAI cpuTwoHard = new HardAI();
        Player playerOne = new Player();
        Player playerTwo = new Player();

        while (true) {
            System.out.print("Input command: ");

            String input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            }

            switch (input) {

                case "start easy easy":
                    cpuOneEasy.setGameLetter("X");
                    cpuTwoEasy.setGameLetter("O");
                    board.emptyBoard();
                    cpuEasyVersusCPUEasy(cpuOneEasy, cpuTwoEasy, board);
                    break;
                case "start medium medium":
                    cpuOneMedium.setGameLetter("X");
                    cpuTwoMedium.setGameLetter("O");
                    board.emptyBoard();
                    mediumCPUVersusMediumCPU(cpuOneMedium, cpuTwoMedium, board);
                    break;
                case "start hard hard":
                    cpuOneHard.setGameLetter("X");
                    cpuOneHard.setOpponent("O");
                    cpuTwoHard.setGameLetter("O");
                    cpuTwoHard.setOpponent("X");
                    board.emptyBoard();
                    hardCPUVersusHardCPU(cpuOneHard, cpuTwoHard, board);
                    break;
                case "start user easy":
                    playerOne.setGameLetter("X");
                    cpuOneEasy.setGameLetter("O");
                    board.emptyBoard();
                    playerVersusCPUEasy(playerOne, cpuOneEasy, board);
                    break;
                case "start user medium":
                    playerOne.setGameLetter("X");
                    cpuOneMedium.setGameLetter("O");
                    board.emptyBoard();
                    playerVersusMediumCPU(playerOne, cpuOneMedium, board);
                    break;
                case "start user hard":
                    playerOne.setGameLetter("X");
                    cpuOneHard.setGameLetter("O");
                    cpuOneHard.setOpponent("X");
                    board.emptyBoard();
                    playerVersusHardCPU(playerOne, cpuOneHard, board);
                    break;
                case "start hard user":
                    cpuOneHard.setGameLetter("X");
                    cpuOneHard.setOpponent("O");
                    playerOne.setGameLetter("O");
                    board.emptyBoard();
                    hardCPUVersusPlayer(cpuOneHard, playerOne, board);
                    break;
                case "start user user":
                    playerOne.setGameLetter("X");
                    playerTwo.setGameLetter("O");
                    board.emptyBoard();
                    playerVersusPlayer(playerOne, playerTwo, board);
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