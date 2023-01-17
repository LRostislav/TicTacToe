import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        // creating a playing area
        char [][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };

        printGameBoard(gameBoard);

        // entering a move
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your placement (1-9): ");
        int playerPos = scan.nextInt();

        // executing a move
        placePiece(gameBoard, playerPos, "player");

        // random computer move
        Random rand = new Random();
        int cpuPos = rand.nextInt(9) + 1;
        while (cpuPos == playerPos) {
            cpuPos = rand.nextInt(9) + 1;
        }
        placePiece(gameBoard,cpuPos,"cpu");

        printGameBoard(gameBoard);
    }


    public static void printGameBoard(char [][] gameBoard){
        for(char[] row : gameBoard){
            for(char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }


    public static void placePiece(char[][] gameBoard, int pos, String user) {

        char symbol = ' ';

        if(user.equals("player")) {
            symbol = 'X';
        } else if(user.equals("cpu")) {
            symbol = 'O';
        }

        switch (pos) {
            case 1 -> gameBoard[0][0] = symbol;
            case 2 -> gameBoard[0][2] = symbol;
            case 3 -> gameBoard[0][4] = symbol;
            case 4 -> gameBoard[2][0] = symbol;
            case 5 -> gameBoard[2][2] = symbol;
            case 6 -> gameBoard[2][4] = symbol;
            case 7 -> gameBoard[4][0] = symbol;
            case 8 -> gameBoard[4][2] = symbol;
            case 9 -> gameBoard[4][4] = symbol;
            default -> {
            }
        }
    }
}
