package tictactoe;

import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final char [][] charArray = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private static final GameStats gameStats = new GameStats();
    private static boolean gameContinues = true;
    private static boolean enterX = true;

    public static void main(String[] args) {
        while(gameContinues) {
            printCharArray();
            userMove();
            scanArray();
            checkGameStatus();
        }
    }

    private static void checkGameStatus() {
        if (gameStats.getX3s() == 1 && gameStats.getO3s() == 0) {
            printCharArray();
            System.out.println("X wins");
            gameContinues = false;
        } else if (gameStats.getX3s() == 0 && gameStats.getO3s() == 1) {
            printCharArray();
            System.out.println("O wins");
            gameContinues = false;
        } else if (gameStats.getEmptyCount() == 0 && gameStats.getX3s() == 0 && gameStats.getO3s() == 0) {
            printCharArray();
            System.out.println("Draw");
            gameContinues = false;
        }
    }

    private static void userMove() {
        boolean incorrectInput = true;
        while (incorrectInput){
            try {
                System.out.print("Enter the coordinates: ");
                int[] input = Arrays.stream(sc.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
                int y = input[0] - 1;
                int x = 3 - input[1];
                incorrectInput = false;
                if (charArray[x][y] == ' ') {
                    charArray[x][y] = enterX ? 'X' : 'O';
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                    incorrectInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                incorrectInput = true;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
                incorrectInput = true;
            }
        }
        enterX = !enterX;
    }

    private static void scanArray() {
        gameStats.setToZero();
        for (int i = 0; i < 3; i++){
            int sum3rows = 0;
//            int sum3cols = 0;
            for(int j = 0; j < 3; j++){
                sum3rows += charArray[i][j];
                if (charArray[i][j] == 'X') {
                    gameStats.addXCount();
                } else if (charArray[i][j] == 'O'){
                    gameStats.addOCount();
                } else {
                    gameStats.addEmptyCount();
                }
            }
            if (sum3rows == 264) {
                gameStats.addX3s();
            } else if (sum3rows == 237) {
                gameStats.addO3s();
            }
        }
        for (int i = 0; i < 3; i++){
            int sum3 = 0;
            for(int j = 0; j < 3; j++){
                sum3 += charArray[j][i];
            }
            if (sum3 == 264) {
                gameStats.addX3s();
            } else if (sum3 == 237) {
                gameStats.addO3s();
            }
        }
        int diagonal1 = charArray[0][0] + charArray[1][1] + charArray[2][2];
        int diagonal2 = charArray[0][2] + charArray[1][1] + charArray[2][0];

        if (diagonal1 == 264){
            gameStats.addX3s();
        } else if (diagonal2 == 264) {
            gameStats.addX3s();
        } else if (diagonal1 == 237) {
            gameStats.addO3s();
        } else if (diagonal2 == 237) {
            gameStats.addO3s();
        }
    }

    private static void printCharArray() {
        System.out.println("---------");
        System.out.println("| " + charArray[0][0] + " " + charArray[0][1] + " " + charArray[0][2] + " |");
        System.out.println("| " + charArray[1][0] + " " + charArray[1][1] + " " + charArray[1][2] + " |");
        System.out.println("| " + charArray[2][0] + " " + charArray[2][1] + " " + charArray[2][2] + " |");
        System.out.println("---------");
    }
}
