import java.util.Random;
import java.util.Scanner;

public class Main {

    private static char[][] board = {{' ',' ',' '}, {' ',' ',' '}, {' ',' ',' '}};

    public static void main(String[] args) {


        while (true) {
            printBoard();
            playerMove();
            if (isGameEnd('X')) {
                printBoard();
                System.out.println("Поздравляем! Вы выиграли!\nИгра окончена.");
                break;
            }
            if (isDraw()) {
                printBoard();
                System.out.println("Ничья.\nИгра окончена.");
                break;
            }
            computerMove();
            if (isGameEnd('0')) {
                printBoard();
                System.out.println("Вы проиграли.\nИгра окончена.");
                break;
            }
            if (isDraw()) {
                printBoard();
                System.out.println("Ничья.\nИгра окончена.");
                break;
            }
        }
    }

    public static void printBoard() {
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2] + '\n' + "- + - + -" + '\n' +
                           board[1][0] + " | " + board[1][1] + " | " + board[1][2] + '\n' + "- + - + -" + '\n' +
                           board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    public static void makeMove(char symbol, int place) {
        switch (place) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2: {
                board[0][1] = symbol;
                break;
            }
            case 3: {
                board[0][2] = symbol;
                break;
            }
            case 4: {
                board[1][0] = symbol;
                break;
            }
            case 5: {
                board[1][1] = symbol;
                break;
            }
            case 6: {
                board[1][2] = symbol;
                break;
            }
            case 7: {
                board[2][0] = symbol;
                break;
            }
            case 8: {
                board[2][1] = symbol;
                break;
            }
            case 9: {
                board[2][2] = symbol;
                break;
            }
        }
    }

    public static boolean isValidMove(int place) {
        boolean isValid = false;
        switch (place) {
            case 1:
                if (board[0][0] == ' ') {
                    isValid = true;
                }
                break;
            case 2: {
                if (board[0][1] == ' ') {
                    isValid = true;
                }
                break;
            }
            case 3: {
                if (board[0][2] == ' ') {
                    isValid = true;
                }
                break;
            }
            case 4: {
                if (board[1][0] == ' ') {
                    isValid = true;
                }
                break;
            }
            case 5: {
                if (board[1][1] == ' ') {
                    isValid = true;
                }
                break;
            }
            case 6: {
                if (board[1][2] == ' ') {
                    isValid = true;
                }
                break;
            }
            case 7: {
                if (board[2][0] == ' ') {
                    isValid = true;
                }
                break;
            }
            case 8: {
                if (board[2][1] == ' ') {
                    isValid = true;
                }
                break;
            }
            case 9: {
                if (board[2][2] == ' ') {
                    isValid = true;
                }
                break;
            }
        }
        return isValid;
    }

    public static void playerMove() {
        System.out.println("Введите номер клетки (1-9).");
        Scanner scanner = new Scanner(System.in);
        int place;
        while (true) {
            try {
                place = scanner.nextInt();
                if (place >= 1 && place <= 9 && isValidMove(place)) {
                    makeMove('X', place);
                    break;
                } else {
                    System.out.println("Ошибка. Неверное число.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка. Введите число.");
                return;
            }
        }
    }

    public static void computerMove() {
        Random random = new Random();
        while (true) {
            int place = random.nextInt(10 - 1) + 1;
            if (isValidMove(place)) {
                makeMove('0', place);
                break;
            }
        }
    }

    public static boolean isGameEnd(char symbol) {
        if ((board[0][0]==symbol && board[0][1]==symbol && board[0][2]==symbol) ||
            (board[1][0]==symbol && board[1][1]==symbol && board[1][2]==symbol) ||
            (board[2][0]==symbol && board[2][1]==symbol && board[2][2]==symbol) ||
            (board[0][0]==symbol && board[1][1]==symbol && board[2][2]==symbol) ||
            (board[2][0]==symbol && board[1][1]==symbol && board[0][2]==symbol) ||
            (board[0][0]==symbol && board[1][0]==symbol && board[2][0]==symbol) ||
            (board[0][1]==symbol && board[1][1]==symbol && board[2][1]==symbol) ||
            (board[0][2]==symbol && board[1][2]==symbol && board[2][2]==symbol)) {
            return true;
        }
        return false;
    }

    public static boolean isDraw() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (board[i][j]==' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
