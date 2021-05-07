import java.util.Scanner;

public class Player {

    private String gameLetter;
    private final Scanner scanner;

    public Player() {

        this.gameLetter = "";
        this.scanner = new Scanner(System.in);
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
                System.out.print("Enter the coordinates: ");
                String playerMove = scanner.nextLine();
                String[] parts = playerMove.split(" ");
                row = Integer.parseInt(parts[0]);
                col = Integer.parseInt(parts[1]);

                if (row < 0 || col < 0 || row > 3 || col > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (gameBoard[row - 1][col - 1].contains("X") ||
                        gameBoard[row - 1][col - 1].contains("O")){
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }
            break;
        }
        board.updateBoard(row - 1, col - 1, gameLetter);
    }
}
