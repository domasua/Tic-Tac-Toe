import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class TicTacToe {

    static ArrayList<Integer> playerXPositions = new ArrayList<Integer>();
    static ArrayList<Integer> playerOPositions = new ArrayList<Integer>();

    public static void main(String[] args) {

        char [] [] Board =     {{' ', '|', ' ', '|', ' '},
                                {'-', '+', '-', '+', '-'},
                                {' ', '|', ' ', '|', ' '},
                                {'-', '+', '-', '+', '-'},
                                {' ', '|', ' ', '|', ' '}}; // tic tac toe zaidimo Lenta 2matis masyvas

        printBoard(Board); // Iskvieciamas printBoard metodas
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("First player move:");
            int playerX = scanner.nextInt();// Pirmas zaidejas iveda norimas koordinates

            System.out.println(playerX);

            placePieceFirstPlayer(Board, playerX, "PlayerX");

            printBoard(Board);

            System.out.println("Second player move:");
            int playerO = scanner.nextInt();// Antras zaidejas iveda norimas koordinates

            System.out.println(playerO);

            placePieceSecondPlayer(Board, playerO, "PlayerO");

            printBoard(Board);

            String checkWinner = checkWinner();

            System.out.println(checkWinner);

        }
    }
    public static void printBoard (char [] [] Board){
        for (char [] row: Board) {
            for ( char i: row ) {
                System.out.print(i);
            }
            System.out.println();

        }

    }
    public static void placePieceFirstPlayer(char[][] Board, int playerX, String user){

        if (user.equals("playerX")){
            playerXPositions.add(playerX);
        }

        switch (playerX){ // keicia tarpa i atitinkama simboli X
            case 1:
                Board [0] [0] = 'X';
                break;
            case 2:
                Board [0] [2] = 'X';
                break;
            case 3:
                Board [0] [4] = 'X';
                break;
            case 4:
                Board [2] [0] = 'X';
                break;
            case 5:
                Board [2] [2] = 'X';
                break;
            case 6:
                Board [2] [4] = 'X';
                break;
            case 7:
                Board [4] [0] = 'X';
                break;
            case 8:
                Board [4] [2] = 'X';
                break;
            case 9:
                Board [4] [4] = 'X';
                break;
        }
    }
    public static void placePieceSecondPlayer(char[][] Board, int playerO, String user){

        if (user.equals("playerO")){
            playerOPositions.add(playerO);
        }
        switch (playerO){ // keicia tarpa i atitinkama simboli 0
            case 1:
                Board [0] [0] = 'O';
                break;
            case 2:
                Board [0] [2] = 'O';
                break;
            case 3:
                Board [0] [4] = 'O';
                break;
            case 4:
                Board [2] [0] = 'O';
                break;
            case 5:
                Board [2] [2] = 'O';
                break;
            case 6:
                Board [2] [4] = 'O';
                break;
            case 7:
                Board [4] [0] = 'O';
                break;
            case 8:
                Board [4] [2] = 'O';
                break;
            case 9:
                Board [4] [4] = 'O';
                break;

        }
    }
    public static String checkWinner (){

        List firstRow = Arrays.asList(1, 2, 3);
        List secondRow = Arrays.asList(4, 5, 6);
        List thirdRow = Arrays.asList(7, 8, 9);
        List firstColumn = Arrays.asList(1, 4, 7);
        List secondColumn = Arrays.asList(2, 5, 8);
        List thirdColumn = Arrays.asList(3, 6, 9);
        List crossOne = Arrays.asList(1, 5, 9);
        List crossTwo = Arrays.asList(3, 5, 7);

        List<List> winningCondition = new ArrayList<List>();

        winningCondition.add(firstRow);
        winningCondition.add(secondRow);
        winningCondition.add(thirdRow);
        winningCondition.add(firstColumn);
        winningCondition.add(secondColumn);
        winningCondition.add(thirdColumn);
        winningCondition.add(crossOne);
        winningCondition.add(crossTwo);

        for (List i: winningCondition){
            if (playerXPositions.containsAll(i)) {
                return "Player 1 is a winner!";
            }
            else if (playerOPositions.containsAll(winningCondition)){
                return "Player 2 is a winner!";
            }
            else if (playerXPositions.size() + playerOPositions.size() == 9){
                return "It is a tie!";
            }
        }
        return "";
    }
}
