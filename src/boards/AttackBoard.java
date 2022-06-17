package boards;

/*
This board will keep record of the attacks, as well as which are misses and which are hits.
*/
public class AttackBoard {
    private String[][] board;

    public AttackBoard() {
        board = new String[10][10];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ".";
            }
        }
    }

    public void markAttack(int xAttack, int yAttack, boolean hit) {
        if (hit) {
            board[xAttack][yAttack] = "X";
        } else {
            board[xAttack][yAttack] = "O";
        }
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
