import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        String[][] gameBoard = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        int position;
        int numTurns = 0;
        String x = "X";
        String o = "O";
        String player;

        while (numTurns < 9 && !checkForWins(gameBoard)) {
            if (numTurns % 2 == 0) {
                player = x;
            } else {
                player = o;
            }
            position = getUserSel();
            playRound(gameBoard, position, player);
            printGameBoard(gameBoard);
            numTurns++;
        }
        println("Someone won!");
        }

    public static boolean checkForWins(String[][] gameBoard) {
        
        return checkRowWins(gameBoard) || checkColWins(gameBoard);   
    }

    public static boolean checkRowWins(String[][] gameBoard) {
        boolean winner = false;
        for (int i = 0; i<3; i++) {
            if (gameBoard[i][0].equals(gameBoard[i][1]) && gameBoard[i][0].equals(gameBoard[i][2])) {
                if (gameBoard[i][0].equals(" ") ) {
                    winner = false;
                } else {
                    winner = true;
                    break;
                }
            } else {
                winner = false;
            }
        }
        return winner;
    }
    public static boolean checkColWins(String[][] gameBoard) {
        boolean winner = false;
        for (int i = 0; i<3; i++) {
            if (gameBoard[0][i].equals(gameBoard[1][i]) && gameBoard[0][i].equals(gameBoard[2][i])) {
                if (gameBoard[0][i].equals(" ") ) {
                    winner = false;
                } else {
                    winner = true;
                    break;
                }
            } else {
                winner = false;
            }
        }
        return winner;
    }

    public static int getUserSel() {
        Scanner k = new Scanner(System.in);
        int[][] numpad = {{1,2,3}, {4,5,6}, {7,8,9}};
        printNumpad(numpad);
        print("\nWhere would you like to go? ");
        return k.nextInt();
    }

    public static void printNumpad(int[][] numpad) {
        println("\n");
        for (int[] row : numpad) {
            for (int num : row) {
                print(num + " ");
            }
            println("");
        }
    }

    public static void printGameBoard(String[][] board) {
        for (String[] row : board) {
            for (String num : row) {
                print(num + " ");
            }
            println("");
        }
    }

    public static String[][] playRound(String[][] gameBoard, int position, String player) {
        gameBoard[posRow(position)][posCol(position)] = player;
        return gameBoard;
    }

    public static int posRow(int position) {
        int row;
        if (position == 1 || position == 2 || position == 3) {
            row = 0; 
        } else if (position == 4 || position == 5 || position == 6) {
            row = 1;
        } else {
            row = 2;
        }
        return row;
    }
    public static int posCol(int position) {
        int col;
        if (position == 1 || position == 4 || position == 7) {
            col = 0;
        } else if (position == 2 || position == 5 || position == 8) {
            col = 1;
        } else {
            col = 2;
        }
        return col;
    }

    public static void println(String s) {
        System.out.println(s);
    }
    public static void print(String s) {
        System.out.print(s);
    }
}