package boards;

/*
This is the enemys board, and for the purpose of this application the ships are already set in
predetermined positions.
*/
public class EnemyBoard {
    private String[][] board;

    public EnemyBoard() {
        board = new String[10][10];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ".";
            }
        }

        // Insert battleship
        for (int i = 0; i < 4; i++) {
            board[i][0] = "B";
        }

        // Insert aircraft carrier
        for (int i = 0; i < 5; i++) {
            board[9][i] = "A";
        }

        // Insert Cruiser
        for (int i = 7; i < 10; i++) {
            board[3][i] = "C";
        }

        // Insert 1st Destroyer
        for (int i = 8; i < 10; i++) {
            board[i][9] = "D";
        }

        // Insert 2nd Destroyer
        for (int i = 2; i < 4; i++) {
            board[6][i] = "D";
        }

        // Insert 1st Submarine
        board[3][4] = "S";

        // Insert 2nd Submarine
        board[5][9] = "S";
    }

    public boolean giveAttack(int xAttack, int yAttack) {
        if (board[xAttack][yAttack].equals("A")) {
            board[xAttack][yAttack] = "X";
            System.out.println("You hit the enemy Aircraft Carrier");
        } else if (board[xAttack][yAttack].equals("B")) {
            board[xAttack][yAttack] = "X";
            System.out.println("You hit the enemy Battleship");
        } else if (board[xAttack][yAttack].equals("C")) {
            board[xAttack][yAttack] = "X";
            System.out.println("You hit the enemy Cruiser");
        } else if (board[xAttack][yAttack].equals("D")) {
            board[xAttack][yAttack] = "X";
            System.out.println("You hit the enemy Destroyer");
        } else if (board[xAttack][yAttack].equals("S")) {
            board[xAttack][yAttack] = "X";
            System.out.println("You hit the enemy Submarine");
        } else {
            System.out.println("You missed!");
            return false;
        }

        return true;
    }

    public boolean hasLost() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!board[i][j].equals(".") && !board[i][j].equals("X")) {
                    return false;
                }
            }
        }
        return true;
    }

    public String print() {
        String answer = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                answer += " ";
                answer += board[i][j];
                answer += " ";
            }
            answer += "\n";
        }
        System.out.println(answer);
        return answer;
    }
}
